//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.783477800
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.class
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.ClassQuery
import org.springframework.stereotype.Repository



@Repository
interface ClassRepository{
   	fun create(class:class):Long
	fun bulkCreate(classs:List<class>)
	fun update(class:class):Int
	fun delete(classId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<class>
	fun readByClassId(classId: Int):Class?
	fun readByClassName(className: String):MutableList<Class>
	fun readByClassTeacherId(classTeacherId: Int):MutableList<Class>
	fun readByClassStatus(classStatus: String):MutableList<Class>
	fun readByClassCreatedAt(classCreatedAt: String):MutableList<Class>
	fun readByClassUpdatedAt(classUpdatedAt: String):MutableList<Class>
}

@Repository
class ClassRepositoryImpl(private val environment: Environment): ClassRepository{
   	override fun create(class:Class):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ClassQuery.INSERT)
			.bind(class)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(classs:List<class>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(ClassQuery.INSERT, false)
			for (class in classs)
				query?.bind(class)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(class:Class):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ClassQuery.UPDATE)
		.bind(class)
		.executeUpdate().result
	}

	override fun delete(classId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ClassQuery.DELETE)
		.addParameter("classId", classId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(ClassQuery.TRUNCATE)
	}

	override fun read():MutableList<class>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ClassQuery.READ)
		.executeAndFetch(class::class.java)
	}

	override fun readByClassId(classId: Int):Class?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_ID)
				.addParameter("classId", classId)
				.executeAndFetch(Class::class.java).firstOrNull()
	}

	override fun readByClassName(className: String):MutableList<Class>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_NAME)
				.addParameter("className", className)
				.executeAndFetch(Class::class.java)
	}

	override fun readByClassTeacherId(classTeacherId: Int):MutableList<Class>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_TEACHER_ID)
				.addParameter("classTeacherId", classTeacherId)
				.executeAndFetch(Class::class.java)
	}

	override fun readByClassStatus(classStatus: String):MutableList<Class>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_STATUS)
				.addParameter("classStatus", classStatus)
				.executeAndFetch(Class::class.java)
	}

	override fun readByClassCreatedAt(classCreatedAt: String):MutableList<Class>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_CREATED_AT)
				.addParameter("classCreatedAt", classCreatedAt)
				.executeAndFetch(Class::class.java)
	}

	override fun readByClassUpdatedAt(classUpdatedAt: String):MutableList<Class>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ClassQuery.READ_BY_CLASS_UPDATED_AT)
				.addParameter("classUpdatedAt", classUpdatedAt)
				.executeAndFetch(Class::class.java)
	}
}
