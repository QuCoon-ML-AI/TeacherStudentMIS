//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object teacherQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}TEACHER(
			teacherEmail,
			teacherName,
			teacherStatus,
			teacherCreatedAt,
			teacherUpdatedAt,
			teacherPassword
		) VALUES (
			:teacherEmail,
			:teacherName,
			COALESCE(:teacherStatus,'ACTIVE'),
			COALESCE(:teacherCreatedAt,getdate()),
			COALESCE(:teacherUpdatedAt,getdate()),
			:teacherPassword
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}TEACHER SET
			teacherEmail=:teacherEmail,
			teacherName=:teacherName,
			teacherStatus=:teacherStatus,
			teacherCreatedAt=:teacherCreatedAt,
			teacherUpdatedAt=GETDATE(),
			teacherPassword=:teacherPassword
		WHERE teacherId=:teacherId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}TEACHER SET teacherStatus = 'DELETED', teacherUpdatedAt = GETDATE()
		WHERE teacherId=:teacherId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}TEACHER 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherId=:teacherId AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_EMAIL = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherEmail=:teacherEmail AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherName=:teacherName AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherStatus=:teacherStatus AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherCreatedAt=:teacherCreatedAt AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherUpdatedAt=:teacherUpdatedAt AND teacherStatus<>'DELETED'
	"""

	const val READ_BY_TEACHER_PASSWORD = """
		SELECT * FROM ${PrefixConstant.ENTITY}TEACHER WHERE teacherPassword=:teacherPassword AND teacherStatus<>'DELETED'
	"""
}
