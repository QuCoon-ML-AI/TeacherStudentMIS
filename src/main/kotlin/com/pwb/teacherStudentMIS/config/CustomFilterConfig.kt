//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.config

import com.pwb.teacherStudentMIS.utility.Environment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.*
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper
import javax.servlet.http.HttpServletResponse
import com.pwb.teacherStudentMIS.model.request.AuditLogCreateRequest
import com.pwb.teacherStudentMIS.service.AuditLogService
import org.json.JSONObject

@Component
class CustomFilterConfig : Filter {

    @Autowired
    lateinit var environment: Environment

    @Autowired
    lateinit var auditLogService: AuditLogService

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig?) {
        // Initialization code if needed
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val stage = httpRequest.requestURI.removePrefix("/").split("/")[0]
        val wrappedRequest: HttpServletRequest = BufferedRequestWrapper(httpRequest)

        // Execute the method first
        executeFirstMethod(stage)

        environment.ipAddress = httpRequest.remoteAddr

        //chain.doFilter(request, response)
        val responseCopier = HttpServletResponseCopier(response as HttpServletResponse?)
        try {
            val bufferedRequestWrapper = wrappedRequest as BufferedRequestWrapper
            val capturedInputStream: InputStream = bufferedRequestWrapper.capturedInputStream
            val requestString = InputStreamReader(capturedInputStream).readText()
            environment.maker = JSONObject(requestString).optString("maker")
        } catch (_: Exception){}
        chain.doFilter(wrappedRequest, responseCopier)
        responseCopier.flushBuffer()

        executeLastMethod(wrappedRequest,response,responseCopier)
    }

    override fun destroy() {
        // Cleanup code if needed
    }

    private fun executeFirstMethod(stage: String) {
        if (stage != "swagger-ui" && stage != "swagger-resources" && stage != "v2") environment.initialize(stage)
    }

    private fun executeLastMethod(request: ServletRequest?,response: ServletResponse?, responseCopier: HttpServletResponseCopier) {
        val copy = responseCopier.copy
        var responseString = java.lang.String(copy, response?.characterEncoding?:"UTF-8")
        val bufferedRequestWrapper = request as BufferedRequestWrapper
        val capturedInputStream: InputStream = bufferedRequestWrapper.capturedInputStream
        var requestString = InputStreamReader(capturedInputStream).readText()
        val httpRequestList = request.requestURI.removePrefix("/").split("/")
        if (environment.userInfo != null)
            auditLogService.create(AuditLogCreateRequest(
                auditLogUserId=environment.userInfo!!.teacherId,
                auditLogAction=httpRequestList[2].replace("-","_").uppercase(),
                auditLogRequest=if(requestString.isNotEmpty()) requestString.take(2000) else request.requestURI,
                auditLogResponse=responseString.toString().take(2000),
                auditLogModule=httpRequestList[1].replace("-","_").uppercase(),
                auditLogResponseCode= JSONObject(responseString).optString("responseCode"),
                auditLogResponseMessage=JSONObject(responseString).optString("responseMessage"),
                auditLogStatus="ACTIVE"
            ))
        // Your logic for the method to be executed last
        environment.databaseUtil?.sql2oConnection?.close()
    }

    private class BufferedRequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
        private val buffer: ByteArray

        init {
            val inputStream: InputStream = request.inputStream
            val baos = ByteArrayOutputStream()
            val buf = ByteArray(1024)
            var bytesRead: Int
            while (inputStream.read(buf).also { bytesRead = it } > 0) {
                baos.write(buf, 0, bytesRead)
            }
            buffer = baos.toByteArray()
        }

        @Throws(IOException::class)
        override fun getInputStream(): ServletInputStream {
            return BufferedServletInputStream(buffer)
        }

        val capturedInputStream: InputStream
            get() = ByteArrayInputStream(buffer)
    }

    private class BufferedServletInputStream(buffer: ByteArray?) : ServletInputStream() {
        private val inputStream: ByteArrayInputStream

        init {
            inputStream = ByteArrayInputStream(buffer)
        }

        @Throws(IOException::class)
        override fun read(): Int {
            return inputStream.read()
        }

        override fun isFinished(): Boolean {
            TODO("Not yet implemented")
        }

        override fun isReady(): Boolean {
            TODO("Not yet implemented")
        }

        override fun setReadListener(listener: ReadListener?) {
            TODO("Not yet implemented")
        }
    }

}
