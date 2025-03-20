//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.teacher
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.TeacherQuery
import org.springframework.stereotype.Repository



@Repository
interface TeacherRepository{
   	fun create(teacher:teacher):Long
	fun bulkCreate(teachers:List<teacher>)
	fun update(teacher:teacher):Int
	fun delete(teacherId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<teacher>
	fun readByTeacherId(teacherId: Int):Teacher?
	fun readByTeacherEmail(teacherEmail: String):MutableList<Teacher>
	fun readByTeacherName(teacherName: String):MutableList<Teacher>
	fun readByTeacherStatus(teacherStatus: String):MutableList<Teacher>
	fun readByTeacherCreatedAt(teacherCreatedAt: String):MutableList<Teacher>
	fun readByTeacherUpdatedAt(teacherUpdatedAt: String):MutableList<Teacher>
	fun readByTeacherPassword(teacherPassword: String):MutableList<Teacher>
}

@Repository
class TeacherRepositoryImpl(private val environment: Environment): TeacherRepository{
   	override fun create(teacher:Teacher):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(TeacherQuery.INSERT)
			.bind(teacher)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(teachers:List<teacher>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(TeacherQuery.INSERT, false)
			for (teacher in teachers)
				query?.bind(teacher)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(teacher:Teacher):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(TeacherQuery.UPDATE)
		.bind(teacher)
		.executeUpdate().result
	}

	override fun delete(teacherId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(TeacherQuery.DELETE)
		.addParameter("teacherId", teacherId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(TeacherQuery.TRUNCATE)
	}

	override fun read():MutableList<teacher>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(TeacherQuery.READ)
		.executeAndFetch(teacher::class.java)
	}

	override fun readByTeacherId(teacherId: Int):Teacher?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_ID)
				.addParameter("teacherId", teacherId)
				.executeAndFetch(Teacher::class.java).firstOrNull()
	}

	override fun readByTeacherEmail(teacherEmail: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_EMAIL)
				.addParameter("teacherEmail", teacherEmail)
				.executeAndFetch(Teacher::class.java)
	}

	override fun readByTeacherName(teacherName: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_NAME)
				.addParameter("teacherName", teacherName)
				.executeAndFetch(Teacher::class.java)
	}

	override fun readByTeacherStatus(teacherStatus: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_STATUS)
				.addParameter("teacherStatus", teacherStatus)
				.executeAndFetch(Teacher::class.java)
	}

	override fun readByTeacherCreatedAt(teacherCreatedAt: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_CREATED_AT)
				.addParameter("teacherCreatedAt", teacherCreatedAt)
				.executeAndFetch(Teacher::class.java)
	}

	override fun readByTeacherUpdatedAt(teacherUpdatedAt: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_UPDATED_AT)
				.addParameter("teacherUpdatedAt", teacherUpdatedAt)
				.executeAndFetch(Teacher::class.java)
	}

	override fun readByTeacherPassword(teacherPassword: String):MutableList<Teacher>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(TeacherQuery.READ_BY_TEACHER_PASSWORD)
				.addParameter("teacherPassword", teacherPassword)
				.executeAndFetch(Teacher::class.java)
	}
}
