//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.814741700
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object LoginHistoryQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}LOGIN_HISTORY(
			loginHistoryUsername,
			loginHistoryIpAddress,
			loginHistoryDeviceId,
			loginHistoryLongitude,
			loginHistoryLatitude,
			loginHistoryStatus,
			loginHistoryCreatedAt,
			loginHistoryUpdatedAt
		) VALUES (
			:loginHistoryUsername,
			:loginHistoryIpAddress,
			:loginHistoryDeviceId,
			:loginHistoryLongitude,
			:loginHistoryLatitude,
			COALESCE(:loginHistoryStatus,'ACTIVE'),
			COALESCE(:loginHistoryCreatedAt,getdate()),
			COALESCE(:loginHistoryUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}LOGIN_HISTORY SET
			loginHistoryUsername=:loginHistoryUsername,
			loginHistoryIpAddress=:loginHistoryIpAddress,
			loginHistoryDeviceId=:loginHistoryDeviceId,
			loginHistoryLongitude=:loginHistoryLongitude,
			loginHistoryLatitude=:loginHistoryLatitude,
			loginHistoryStatus=:loginHistoryStatus,
			loginHistoryCreatedAt=:loginHistoryCreatedAt,
			loginHistoryUpdatedAt=GETDATE()
		WHERE loginHistoryId=:loginHistoryId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}LOGIN_HISTORY SET loginHistoryStatus = 'DELETED', loginHistoryUpdatedAt = GETDATE()
		WHERE loginHistoryId=:loginHistoryId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}LOGIN_HISTORY 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryId=:loginHistoryId AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_USERNAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryUsername=:loginHistoryUsername AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_IP_ADDRESS = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryIpAddress=:loginHistoryIpAddress AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_DEVICE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryDeviceId=:loginHistoryDeviceId AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_LONGITUDE = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryLongitude=:loginHistoryLongitude AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_LATITUDE = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryLatitude=:loginHistoryLatitude AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryStatus=:loginHistoryStatus AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryCreatedAt=:loginHistoryCreatedAt AND loginHistoryStatus<>'DELETED'
	"""

	const val READ_BY_LOGIN_HISTORY_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}LOGIN_HISTORY WHERE loginHistoryUpdatedAt=:loginHistoryUpdatedAt AND loginHistoryStatus<>'DELETED'
	"""
}
