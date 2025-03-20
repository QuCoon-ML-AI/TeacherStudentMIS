//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object ModuleQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}MODULE(
			moduleName,
			moduleDescription,
			moduleStatus,
			moduleCreatedAt,
			moduleUpdatedAt
		) VALUES (
			:moduleName,
			:moduleDescription,
			COALESCE(:moduleStatus,'ACTIVE'),
			COALESCE(:moduleCreatedAt,getdate()),
			COALESCE(:moduleUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}MODULE SET
			moduleName=:moduleName,
			moduleDescription=:moduleDescription,
			moduleStatus=:moduleStatus,
			moduleCreatedAt=:moduleCreatedAt,
			moduleUpdatedAt=GETDATE()
		WHERE moduleId=:moduleId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}MODULE SET moduleStatus = 'DELETED', moduleUpdatedAt = GETDATE()
		WHERE moduleId=:moduleId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}MODULE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleId=:moduleId AND moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleName=:moduleName AND moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_DESCRIPTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleDescription=:moduleDescription AND moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleStatus=:moduleStatus AND moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleCreatedAt=:moduleCreatedAt AND moduleStatus<>'DELETED'
	"""

	const val READ_BY_MODULE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}MODULE WHERE moduleUpdatedAt=:moduleUpdatedAt AND moduleStatus<>'DELETED'
	"""
}
