//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.908509300
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.AuditLog
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.AuditLogQuery
import org.springframework.stereotype.Repository



@Repository
interface AuditLogRepository{
   	fun create(auditLog:AuditLog):Long
	fun bulkCreate(auditLogs:List<AuditLog>)
	fun update(auditLog:AuditLog):Int
	fun delete(auditLogId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<AuditLog>
	fun readByAuditLogId(auditLogId: Int):AuditLog?
	fun readByAuditLogUserId(auditLogUserId: Int):MutableList<AuditLog>
	fun readByAuditLogAction(auditLogAction: String):MutableList<AuditLog>
	fun readByAuditLogRequest(auditLogRequest: String):MutableList<AuditLog>
	fun readByAuditLogResponse(auditLogResponse: String):MutableList<AuditLog>
	fun readByAuditLogModule(auditLogModule: String):MutableList<AuditLog>
	fun readByAuditLogResponseCode(auditLogResponseCode: String):MutableList<AuditLog>
	fun readByAuditLogResponseMessage(auditLogResponseMessage: String):MutableList<AuditLog>
	fun readByAuditLogStatus(auditLogStatus: String):MutableList<AuditLog>
	fun readByAuditLogCreatedAt(auditLogCreatedAt: String):MutableList<AuditLog>
	fun readByAuditLogUpdatedAt(auditLogUpdatedAt: String):MutableList<AuditLog>
}

@Repository
class AuditLogRepositoryImpl(private val environment: Environment): AuditLogRepository{
   	override fun create(auditLog:AuditLog):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(AuditLogQuery.INSERT)
			.bind(auditLog)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(auditLogs:List<AuditLog>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(AuditLogQuery.INSERT, false)
			for (auditLog in auditLogs)
				query?.bind(auditLog)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(auditLog:AuditLog):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(AuditLogQuery.UPDATE)
		.bind(auditLog)
		.executeUpdate().result
	}

	override fun delete(auditLogId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(AuditLogQuery.DELETE)
		.addParameter("auditLogId", auditLogId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(AuditLogQuery.TRUNCATE)
	}

	override fun read():MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(AuditLogQuery.READ)
		.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogId(auditLogId: Int):AuditLog?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_ID)
				.addParameter("auditLogId", auditLogId)
				.executeAndFetch(AuditLog::class.java).firstOrNull()
	}

	override fun readByAuditLogUserId(auditLogUserId: Int):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_USER_ID)
				.addParameter("auditLogUserId", auditLogUserId)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogAction(auditLogAction: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_ACTION)
				.addParameter("auditLogAction", auditLogAction)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogRequest(auditLogRequest: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_REQUEST)
				.addParameter("auditLogRequest", auditLogRequest)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogResponse(auditLogResponse: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_RESPONSE)
				.addParameter("auditLogResponse", auditLogResponse)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogModule(auditLogModule: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_MODULE)
				.addParameter("auditLogModule", auditLogModule)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogResponseCode(auditLogResponseCode: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_RESPONSE_CODE)
				.addParameter("auditLogResponseCode", auditLogResponseCode)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogResponseMessage(auditLogResponseMessage: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_RESPONSE_MESSAGE)
				.addParameter("auditLogResponseMessage", auditLogResponseMessage)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogStatus(auditLogStatus: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_STATUS)
				.addParameter("auditLogStatus", auditLogStatus)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogCreatedAt(auditLogCreatedAt: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_CREATED_AT)
				.addParameter("auditLogCreatedAt", auditLogCreatedAt)
				.executeAndFetch(AuditLog::class.java)
	}

	override fun readByAuditLogUpdatedAt(auditLogUpdatedAt: String):MutableList<AuditLog>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(AuditLogQuery.READ_BY_AUDIT_LOG_UPDATED_AT)
				.addParameter("auditLogUpdatedAt", auditLogUpdatedAt)
				.executeAndFetch(AuditLog::class.java)
	}
}
