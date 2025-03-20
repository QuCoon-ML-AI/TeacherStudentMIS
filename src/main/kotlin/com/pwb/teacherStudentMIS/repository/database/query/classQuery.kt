//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.783477800
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object classQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}CLASS(
			className,
			classTeacherId,
			classStatus,
			classCreatedAt,
			classUpdatedAt
		) VALUES (
			:className,
			:classTeacherId,
			COALESCE(:classStatus,'ACTIVE'),
			COALESCE(:classCreatedAt,getdate()),
			COALESCE(:classUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}CLASS SET
			className=:className,
			classTeacherId=:classTeacherId,
			classStatus=:classStatus,
			classCreatedAt=:classCreatedAt,
			classUpdatedAt=GETDATE()
		WHERE classId=:classId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}CLASS SET classStatus = 'DELETED', classUpdatedAt = GETDATE()
		WHERE classId=:classId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}CLASS 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classId=:classId AND classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE className=:className AND classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_TEACHER_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classTeacherId=:classTeacherId AND classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classStatus=:classStatus AND classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classCreatedAt=:classCreatedAt AND classStatus<>'DELETED'
	"""

	const val READ_BY_CLASS_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}CLASS WHERE classUpdatedAt=:classUpdatedAt AND classStatus<>'DELETED'
	"""
}
