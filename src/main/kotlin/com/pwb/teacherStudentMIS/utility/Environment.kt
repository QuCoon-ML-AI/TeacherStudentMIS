//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.utility

import org.pwb.utility.aws.model.response.AwsSecretResponse
import org.pwb.utility.database.DatabaseUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.pwb.utility.jwt.JwtUtil
import com.pwb.teacherStudentMIS.model.response.LoginResponse
import org.springframework.web.context.WebApplicationContext


//@Configuration(value = "myEnviroment")
@Component(value = "myEnviroment")
@Scope(WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class Environment {

    @Autowired
    lateinit var properties: Environment

    var applicationName: String = "teacherStudentMIS"
    var ipAddress: String? = null
    var maker: String? = null
    var client: String? = null
    var jwtUtil: JwtUtil = JwtUtil()
    var authorizationHeader: String? = null
    var authorizationRequired: Boolean = true
    var stage: String? = null
    var smtpFromEmail: String? = null
    var smtpFromName: String? = null
    var smtpApiKey: String? = null
    var applicationPath: String? = null
    var awsSecretName: List<String>? = null
    var mid: String? = null
    var userInfo: LoginResponse? = null
    var awsSecret: AwsSecretResponse? = null //AwsSecret by KoinJavaComponent.inject(AwsSecret::class.java)
    var databaseUtil: DatabaseUtil? = null
    var isDatasource: Boolean = false
    var executeDatabaseMigration: Boolean = false

    fun initialize(newStage: String) {

        if (client.isNullOrEmpty()) client = properties.getProperty("app.client")
        stage = newStage
        isDatasource = properties.getProperty("app.is.datasource").toBoolean()
        println("initializing to $stage... isDatasource to $isDatasource")
        //todo get secrete name
        val property = properties.getProperty("app.client")

        applicationPath = properties.getProperty("application.path")
        executeDatabaseMigration = properties.getProperty("app.datasource.migration")!!.toBoolean()

        awsSecretName = properties.getProperty("$client.aws.secretName").toString().split(",")

        awsSecret = AwsSecretResponse(
            pwbUrl = properties.getProperty("datasource.url"),
            pwbUsername = properties.getProperty("datasource.username"),
            pwbPassword = properties.getProperty("datasource.password"),
            jndi = properties.getProperty("datasource.jndi")
        )

        databaseUtil?.sql2oConnection?.close()
        databaseUtil = DatabaseUtil(awsSecret, isDatasource)
    }
}


