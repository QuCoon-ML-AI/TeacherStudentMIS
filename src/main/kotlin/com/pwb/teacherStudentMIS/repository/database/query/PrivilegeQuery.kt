//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.830377400
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object PrivilegeQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}PRIVILEGE(
			privilegeCode,
			privilegeName,
			privilegeModuleName,
			privilegeDescription,
			privilegeStatus,
			privilegeCreatedAt,
			privilegeUpdatedAt
		) VALUES (
			:privilegeCode,
			:privilegeName,
			:privilegeModuleName,
			:privilegeDescription,
			COALESCE(:privilegeStatus,'ACTIVE'),
			COALESCE(:privilegeCreatedAt,getdate()),
			COALESCE(:privilegeUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}PRIVILEGE SET
			privilegeCode=:privilegeCode,
			privilegeName=:privilegeName,
			privilegeModuleName=:privilegeModuleName,
			privilegeDescription=:privilegeDescription,
			privilegeStatus=:privilegeStatus,
			privilegeCreatedAt=:privilegeCreatedAt,
			privilegeUpdatedAt=GETDATE()
		WHERE privilegeId=:privilegeId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}PRIVILEGE SET privilegeStatus = 'DELETED', privilegeUpdatedAt = GETDATE()
		WHERE privilegeId=:privilegeId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}PRIVILEGE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeId=:privilegeId AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_CODE = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeCode=:privilegeCode AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeName=:privilegeName AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_MODULE_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeModuleName=:privilegeModuleName AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_DESCRIPTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeDescription=:privilegeDescription AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeStatus=:privilegeStatus AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeCreatedAt=:privilegeCreatedAt AND privilegeStatus<>'DELETED'
	"""

	const val READ_BY_PRIVILEGE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}PRIVILEGE WHERE privilegeUpdatedAt=:privilegeUpdatedAt AND privilegeStatus<>'DELETED'
	"""
}
