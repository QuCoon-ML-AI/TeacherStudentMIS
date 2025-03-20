//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.Role
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.RoleQuery
import org.springframework.stereotype.Repository



@Repository
interface RoleRepository{
   	fun create(role:Role):Long
	fun bulkCreate(roles:List<Role>)
	fun update(role:Role):Int
	fun delete(roleId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<Role>
	fun readByRoleId(roleId: Int):Role?
	fun readByRoleName(roleName: String):MutableList<Role>
	fun readByRoleDescription(roleDescription: String):MutableList<Role>
	fun readByRoleIsPublic(roleIsPublic: String):MutableList<Role>
	fun readByRoleStatus(roleStatus: String):MutableList<Role>
	fun readByRoleCreatedAt(roleCreatedAt: String):MutableList<Role>
	fun readByRoleUpdatedAt(roleUpdatedAt: String):MutableList<Role>
}

@Repository
class RoleRepositoryImpl(private val environment: Environment): RoleRepository{
   	override fun create(role:Role):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RoleQuery.INSERT)
			.bind(role)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(roles:List<Role>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(RoleQuery.INSERT, false)
			for (role in roles)
				query?.bind(role)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(role:Role):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RoleQuery.UPDATE)
		.bind(role)
		.executeUpdate().result
	}

	override fun delete(roleId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RoleQuery.DELETE)
		.addParameter("roleId", roleId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(RoleQuery.TRUNCATE)
	}

	override fun read():MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RoleQuery.READ)
		.executeAndFetch(Role::class.java)
	}

	override fun readByRoleId(roleId: Int):Role?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_ID)
				.addParameter("roleId", roleId)
				.executeAndFetch(Role::class.java).firstOrNull()
	}

	override fun readByRoleName(roleName: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_NAME)
				.addParameter("roleName", roleName)
				.executeAndFetch(Role::class.java)
	}

	override fun readByRoleDescription(roleDescription: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_DESCRIPTION)
				.addParameter("roleDescription", roleDescription)
				.executeAndFetch(Role::class.java)
	}

	override fun readByRoleIsPublic(roleIsPublic: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_IS_PUBLIC)
				.addParameter("roleIsPublic", roleIsPublic)
				.executeAndFetch(Role::class.java)
	}

	override fun readByRoleStatus(roleStatus: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_STATUS)
				.addParameter("roleStatus", roleStatus)
				.executeAndFetch(Role::class.java)
	}

	override fun readByRoleCreatedAt(roleCreatedAt: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_CREATED_AT)
				.addParameter("roleCreatedAt", roleCreatedAt)
				.executeAndFetch(Role::class.java)
	}

	override fun readByRoleUpdatedAt(roleUpdatedAt: String):MutableList<Role>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RoleQuery.READ_BY_ROLE_UPDATED_AT)
				.addParameter("roleUpdatedAt", roleUpdatedAt)
				.executeAndFetch(Role::class.java)
	}
}
