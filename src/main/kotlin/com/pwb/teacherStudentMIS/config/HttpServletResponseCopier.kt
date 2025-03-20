//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.config

import java.io.IOException
import java.io.OutputStreamWriter
import java.io.PrintWriter
import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponseWrapper

class HttpServletResponseCopier(response: HttpServletResponse?) : HttpServletResponseWrapper(response) {
    private var outputStream: ServletOutputStream? = null
    private var writer: PrintWriter? = null
    private var copier: ServletOutputStreamCopier? = null

    @Throws(IOException::class)
    override fun getOutputStream(): ServletOutputStream {
        check(writer == null) { "getWriter() has already been called on this response." }
        if (outputStream == null) {
            outputStream = response.outputStream
            copier = ServletOutputStreamCopier(outputStream!!)
        }
        return copier!!
    }

    @Throws(IOException::class)
    override fun getWriter(): PrintWriter {
        check(outputStream == null) { "getOutputStream() has already been called on this response." }
        if (writer == null) {
            copier = ServletOutputStreamCopier(response.outputStream)
            writer = PrintWriter(OutputStreamWriter(copier!!, response.characterEncoding), true)
        }
        return writer!!
    }

    @Throws(IOException::class)
    override fun flushBuffer() {
        if (writer != null) {
            writer!!.flush()
        } else if (outputStream != null) {
            copier!!.flush()
        }
    }

    val copy: ByteArray
        get() = if (copier != null) {
            copier!!.getCopy()
        } else {
            ByteArray(0)
        }
}
