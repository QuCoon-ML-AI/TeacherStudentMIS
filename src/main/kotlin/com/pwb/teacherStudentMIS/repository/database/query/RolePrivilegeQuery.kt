//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object RolePrivilegeQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}ROLE_PRIVILEGE(
			rolePrivilegeRoleId,
			rolePrivilegePrivilegeCode,
			rolePrivilegeStatus,
			rolePrivilegeCreatedAt,
			rolePrivilegeUpdatedAt
		) VALUES (
			:rolePrivilegeRoleId,
			:rolePrivilegePrivilegeCode,
			COALESCE(:rolePrivilegeStatus,'ACTIVE'),
			COALESCE(:rolePrivilegeCreatedAt,getdate()),
			COALESCE(:rolePrivilegeUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}ROLE_PRIVILEGE SET
			rolePrivilegeRoleId=:rolePrivilegeRoleId,
			rolePrivilegePrivilegeCode=:rolePrivilegePrivilegeCode,
			rolePrivilegeStatus=:rolePrivilegeStatus,
			rolePrivilegeCreatedAt=:rolePrivilegeCreatedAt,
			rolePrivilegeUpdatedAt=GETDATE()
		WHERE rolePrivilegeId=:rolePrivilegeId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}ROLE_PRIVILEGE SET rolePrivilegeStatus = 'DELETED', rolePrivilegeUpdatedAt = GETDATE()
		WHERE rolePrivilegeId=:rolePrivilegeId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}ROLE_PRIVILEGE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeId=:rolePrivilegeId AND rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_ROLE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeRoleId=:rolePrivilegeRoleId AND rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_PRIVILEGE_CODE = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegePrivilegeCode=:rolePrivilegePrivilegeCode AND rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeStatus=:rolePrivilegeStatus AND rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeCreatedAt=:rolePrivilegeCreatedAt AND rolePrivilegeStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_PRIVILEGE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE_PRIVILEGE WHERE rolePrivilegeUpdatedAt=:rolePrivilegeUpdatedAt AND rolePrivilegeStatus<>'DELETED'
	"""
}
