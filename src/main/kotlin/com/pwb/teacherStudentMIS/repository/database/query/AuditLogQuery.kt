//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.908509300
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object AuditLogQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}AUDIT_LOG(
			auditLogUserId,
			auditLogAction,
			auditLogRequest,
			auditLogResponse,
			auditLogModule,
			auditLogResponseCode,
			auditLogResponseMessage,
			auditLogStatus,
			auditLogCreatedAt,
			auditLogUpdatedAt
		) VALUES (
			:auditLogUserId,
			:auditLogAction,
			:auditLogRequest,
			:auditLogResponse,
			:auditLogModule,
			:auditLogResponseCode,
			:auditLogResponseMessage,
			COALESCE(:auditLogStatus,'ACTIVE'),
			COALESCE(:auditLogCreatedAt,getdate()),
			COALESCE(:auditLogUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}AUDIT_LOG SET
			auditLogUserId=:auditLogUserId,
			auditLogAction=:auditLogAction,
			auditLogRequest=:auditLogRequest,
			auditLogResponse=:auditLogResponse,
			auditLogModule=:auditLogModule,
			auditLogResponseCode=:auditLogResponseCode,
			auditLogResponseMessage=:auditLogResponseMessage,
			auditLogStatus=:auditLogStatus,
			auditLogCreatedAt=:auditLogCreatedAt,
			auditLogUpdatedAt=GETDATE()
		WHERE auditLogId=:auditLogId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}AUDIT_LOG SET auditLogStatus = 'DELETED', auditLogUpdatedAt = GETDATE()
		WHERE auditLogId=:auditLogId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}AUDIT_LOG 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogId=:auditLogId AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_USER_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogUserId=:auditLogUserId AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_ACTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogAction=:auditLogAction AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_REQUEST = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogRequest=:auditLogRequest AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_RESPONSE = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogResponse=:auditLogResponse AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_MODULE = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogModule=:auditLogModule AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_RESPONSE_CODE = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogResponseCode=:auditLogResponseCode AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_RESPONSE_MESSAGE = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogResponseMessage=:auditLogResponseMessage AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogStatus=:auditLogStatus AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogCreatedAt=:auditLogCreatedAt AND auditLogStatus<>'DELETED'
	"""

	const val READ_BY_AUDIT_LOG_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}AUDIT_LOG WHERE auditLogUpdatedAt=:auditLogUpdatedAt AND auditLogStatus<>'DELETED'
	"""
}
