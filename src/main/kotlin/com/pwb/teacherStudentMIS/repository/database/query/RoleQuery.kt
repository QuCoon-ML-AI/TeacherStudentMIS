//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object RoleQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}ROLE(
			roleName,
			roleDescription,
			roleIsPublic,
			roleStatus,
			roleCreatedAt,
			roleUpdatedAt
		) VALUES (
			:roleName,
			:roleDescription,
			COALESCE(:roleIsPublic,'YES'),
			COALESCE(:roleStatus,'ACTIVE'),
			COALESCE(:roleCreatedAt,getdate()),
			COALESCE(:roleUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}ROLE SET
			roleName=:roleName,
			roleDescription=:roleDescription,
			roleIsPublic=:roleIsPublic,
			roleStatus=:roleStatus,
			roleCreatedAt=:roleCreatedAt,
			roleUpdatedAt=GETDATE()
		WHERE roleId=:roleId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}ROLE SET roleStatus = 'DELETED', roleUpdatedAt = GETDATE()
		WHERE roleId=:roleId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}ROLE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleId=:roleId AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleName=:roleName AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_DESCRIPTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleDescription=:roleDescription AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_IS_PUBLIC = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleIsPublic=:roleIsPublic AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleStatus=:roleStatus AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleCreatedAt=:roleCreatedAt AND roleStatus<>'DELETED'
	"""

	const val READ_BY_ROLE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ROLE WHERE roleUpdatedAt=:roleUpdatedAt AND roleStatus<>'DELETED'
	"""
}
