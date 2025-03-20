//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.student
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.StudentQuery
import org.springframework.stereotype.Repository



@Repository
interface StudentRepository{
   	fun create(student:student):Long
	fun bulkCreate(students:List<student>)
	fun update(student:student):Int
	fun delete(studentId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<student>
	fun readByStudentId(studentId: Int):Student?
	fun readByStudentName(studentName: String):MutableList<Student>
	fun readByStudentGrade(studentGrade: String):MutableList<Student>
	fun readByStudentStatus(studentStatus: String):MutableList<Student>
	fun readByStudentCreatedAt(studentCreatedAt: String):MutableList<Student>
	fun readByStudentUpdatedAt(studentUpdatedAt: String):MutableList<Student>
}

@Repository
class StudentRepositoryImpl(private val environment: Environment): StudentRepository{
   	override fun create(student:Student):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(StudentQuery.INSERT)
			.bind(student)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(students:List<student>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(StudentQuery.INSERT, false)
			for (student in students)
				query?.bind(student)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(student:Student):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(StudentQuery.UPDATE)
		.bind(student)
		.executeUpdate().result
	}

	override fun delete(studentId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(StudentQuery.DELETE)
		.addParameter("studentId", studentId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(StudentQuery.TRUNCATE)
	}

	override fun read():MutableList<student>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(StudentQuery.READ)
		.executeAndFetch(student::class.java)
	}

	override fun readByStudentId(studentId: Int):Student?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_ID)
				.addParameter("studentId", studentId)
				.executeAndFetch(Student::class.java).firstOrNull()
	}

	override fun readByStudentName(studentName: String):MutableList<Student>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_NAME)
				.addParameter("studentName", studentName)
				.executeAndFetch(Student::class.java)
	}

	override fun readByStudentGrade(studentGrade: String):MutableList<Student>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_GRADE)
				.addParameter("studentGrade", studentGrade)
				.executeAndFetch(Student::class.java)
	}

	override fun readByStudentStatus(studentStatus: String):MutableList<Student>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_STATUS)
				.addParameter("studentStatus", studentStatus)
				.executeAndFetch(Student::class.java)
	}

	override fun readByStudentCreatedAt(studentCreatedAt: String):MutableList<Student>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_CREATED_AT)
				.addParameter("studentCreatedAt", studentCreatedAt)
				.executeAndFetch(Student::class.java)
	}

	override fun readByStudentUpdatedAt(studentUpdatedAt: String):MutableList<Student>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(StudentQuery.READ_BY_STUDENT_UPDATED_AT)
				.addParameter("studentUpdatedAt", studentUpdatedAt)
				.executeAndFetch(Student::class.java)
	}
}
