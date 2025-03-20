//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.845997800
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.Privilege
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.PrivilegeQuery
import org.springframework.stereotype.Repository



@Repository
interface PrivilegeRepository{
   	fun create(privilege:Privilege):Long
	fun bulkCreate(privileges:List<Privilege>)
	fun update(privilege:Privilege):Int
	fun delete(privilegeId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<Privilege>
	fun readByPrivilegeId(privilegeId: Int):Privilege?
	fun readByPrivilegeCode(privilegeCode: String):MutableList<Privilege>
	fun readByPrivilegeName(privilegeName: String):MutableList<Privilege>
	fun readByPrivilegeModuleName(privilegeModuleName: String):MutableList<Privilege>
	fun readByPrivilegeDescription(privilegeDescription: String):MutableList<Privilege>
	fun readByPrivilegeStatus(privilegeStatus: String):MutableList<Privilege>
	fun readByPrivilegeCreatedAt(privilegeCreatedAt: String):MutableList<Privilege>
	fun readByPrivilegeUpdatedAt(privilegeUpdatedAt: String):MutableList<Privilege>
}

@Repository
class PrivilegeRepositoryImpl(private val environment: Environment): PrivilegeRepository{
   	override fun create(privilege:Privilege):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PrivilegeQuery.INSERT)
			.bind(privilege)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(privileges:List<Privilege>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(PrivilegeQuery.INSERT, false)
			for (privilege in privileges)
				query?.bind(privilege)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(privilege:Privilege):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PrivilegeQuery.UPDATE)
		.bind(privilege)
		.executeUpdate().result
	}

	override fun delete(privilegeId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PrivilegeQuery.DELETE)
		.addParameter("privilegeId", privilegeId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(PrivilegeQuery.TRUNCATE)
	}

	override fun read():MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ)
		.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeId(privilegeId: Int):Privilege?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_ID)
				.addParameter("privilegeId", privilegeId)
				.executeAndFetch(Privilege::class.java).firstOrNull()
	}

	override fun readByPrivilegeCode(privilegeCode: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_CODE)
				.addParameter("privilegeCode", privilegeCode)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeName(privilegeName: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_NAME)
				.addParameter("privilegeName", privilegeName)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeModuleName(privilegeModuleName: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_MODULE_NAME)
				.addParameter("privilegeModuleName", privilegeModuleName)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeDescription(privilegeDescription: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_DESCRIPTION)
				.addParameter("privilegeDescription", privilegeDescription)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeStatus(privilegeStatus: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_STATUS)
				.addParameter("privilegeStatus", privilegeStatus)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeCreatedAt(privilegeCreatedAt: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_CREATED_AT)
				.addParameter("privilegeCreatedAt", privilegeCreatedAt)
				.executeAndFetch(Privilege::class.java)
	}

	override fun readByPrivilegeUpdatedAt(privilegeUpdatedAt: String):MutableList<Privilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PrivilegeQuery.READ_BY_PRIVILEGE_UPDATED_AT)
				.addParameter("privilegeUpdatedAt", privilegeUpdatedAt)
				.executeAndFetch(Privilege::class.java)
	}
}
