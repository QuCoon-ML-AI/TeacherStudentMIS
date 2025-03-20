//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.799246600
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object UserOtpQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}USER_OTP(
			userOtpUsername,
			userOtpOtp,
			userOtpStatus,
			userOtpCreatedAt,
			userOtpUpdatedAt
		) VALUES (
			:userOtpUsername,
			:userOtpOtp,
			COALESCE(:userOtpStatus,'ACTIVE'),
			COALESCE(:userOtpCreatedAt,getdate()),
			COALESCE(:userOtpUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}USER_OTP SET
			userOtpUsername=:userOtpUsername,
			userOtpOtp=:userOtpOtp,
			userOtpStatus=:userOtpStatus,
			userOtpCreatedAt=:userOtpCreatedAt,
			userOtpUpdatedAt=GETDATE()
		WHERE userOtpId=:userOtpId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}USER_OTP SET userOtpStatus = 'DELETED', userOtpUpdatedAt = GETDATE()
		WHERE userOtpId=:userOtpId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}USER_OTP 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpId=:userOtpId AND userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_USERNAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpUsername=:userOtpUsername AND userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_OTP = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpOtp=:userOtpOtp AND userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpStatus=:userOtpStatus AND userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpCreatedAt=:userOtpCreatedAt AND userOtpStatus<>'DELETED'
	"""

	const val READ_BY_USER_OTP_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER_OTP WHERE userOtpUpdatedAt=:userOtpUpdatedAt AND userOtpStatus<>'DELETED'
	"""
}
