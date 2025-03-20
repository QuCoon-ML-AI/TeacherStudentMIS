//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.RolePrivilege
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.RolePrivilegeQuery
import org.springframework.stereotype.Repository



@Repository
interface RolePrivilegeRepository{
   	fun create(rolePrivilege:RolePrivilege):Long
	fun bulkCreate(rolePrivileges:List<RolePrivilege>)
	fun update(rolePrivilege:RolePrivilege):Int
	fun delete(rolePrivilegeId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<RolePrivilege>
	fun readByRolePrivilegeId(rolePrivilegeId: Int):RolePrivilege?
	fun readByRolePrivilegeRoleId(rolePrivilegeRoleId: Int):MutableList<RolePrivilege>
	fun readByRolePrivilegePrivilegeCode(rolePrivilegePrivilegeCode: String):MutableList<RolePrivilege>
	fun readByRolePrivilegeStatus(rolePrivilegeStatus: String):MutableList<RolePrivilege>
	fun readByRolePrivilegeCreatedAt(rolePrivilegeCreatedAt: String):MutableList<RolePrivilege>
	fun readByRolePrivilegeUpdatedAt(rolePrivilegeUpdatedAt: String):MutableList<RolePrivilege>
}

@Repository
class RolePrivilegeRepositoryImpl(private val environment: Environment): RolePrivilegeRepository{
   	override fun create(rolePrivilege:RolePrivilege):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.INSERT)
			.bind(rolePrivilege)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(rolePrivileges:List<RolePrivilege>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.INSERT, false)
			for (rolePrivilege in rolePrivileges)
				query?.bind(rolePrivilege)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(rolePrivilege:RolePrivilege):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.UPDATE)
		.bind(rolePrivilege)
		.executeUpdate().result
	}

	override fun delete(rolePrivilegeId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.DELETE)
		.addParameter("rolePrivilegeId", rolePrivilegeId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(RolePrivilegeQuery.TRUNCATE)
	}

	override fun read():MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ)
		.executeAndFetch(RolePrivilege::class.java)
	}

	override fun readByRolePrivilegeId(rolePrivilegeId: Int):RolePrivilege?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ID)
				.addParameter("rolePrivilegeId", rolePrivilegeId)
				.executeAndFetch(RolePrivilege::class.java).firstOrNull()
	}

	override fun readByRolePrivilegeRoleId(rolePrivilegeRoleId: Int):MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLE_ID)
				.addParameter("rolePrivilegeRoleId", rolePrivilegeRoleId)
				.executeAndFetch(RolePrivilege::class.java)
	}

	override fun readByRolePrivilegePrivilegeCode(rolePrivilegePrivilegeCode: String):MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_PRIVILEGE_CODE)
				.addParameter("rolePrivilegePrivilegeCode", rolePrivilegePrivilegeCode)
				.executeAndFetch(RolePrivilege::class.java)
	}

	override fun readByRolePrivilegeStatus(rolePrivilegeStatus: String):MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_STATUS)
				.addParameter("rolePrivilegeStatus", rolePrivilegeStatus)
				.executeAndFetch(RolePrivilege::class.java)
	}

	override fun readByRolePrivilegeCreatedAt(rolePrivilegeCreatedAt: String):MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_CREATED_AT)
				.addParameter("rolePrivilegeCreatedAt", rolePrivilegeCreatedAt)
				.executeAndFetch(RolePrivilege::class.java)
	}

	override fun readByRolePrivilegeUpdatedAt(rolePrivilegeUpdatedAt: String):MutableList<RolePrivilege>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_UPDATED_AT)
				.addParameter("rolePrivilegeUpdatedAt", rolePrivilegeUpdatedAt)
				.executeAndFetch(RolePrivilege::class.java)
	}
}
