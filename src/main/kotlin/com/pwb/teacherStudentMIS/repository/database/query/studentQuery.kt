//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
package com.pwb.teacherStudentMIS.repository.database.query

import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant


object studentQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}STUDENT(
			studentName,
			studentGrade,
			studentStatus,
			studentCreatedAt,
			studentUpdatedAt
		) VALUES (
			:studentName,
			:studentGrade,
			COALESCE(:studentStatus,'ACTIVE'),
			COALESCE(:studentCreatedAt,getdate()),
			COALESCE(:studentUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}STUDENT SET
			studentName=:studentName,
			studentGrade=:studentGrade,
			studentStatus=:studentStatus,
			studentCreatedAt=:studentCreatedAt,
			studentUpdatedAt=GETDATE()
		WHERE studentId=:studentId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}STUDENT SET studentStatus = 'DELETED', studentUpdatedAt = GETDATE()
		WHERE studentId=:studentId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}STUDENT 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentId=:studentId AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentName=:studentName AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_GRADE = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentGrade=:studentGrade AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentStatus=:studentStatus AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentCreatedAt=:studentCreatedAt AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentUpdatedAt=:studentUpdatedAt AND studentStatus<>'DELETED'
	"""
}
