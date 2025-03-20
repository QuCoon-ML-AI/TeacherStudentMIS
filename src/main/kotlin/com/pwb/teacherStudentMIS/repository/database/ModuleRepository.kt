//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.Module
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.ModuleQuery
import org.springframework.stereotype.Repository



@Repository
interface ModuleRepository{
   	fun create(module:Module):Long
	fun bulkCreate(modules:List<Module>)
	fun update(module:Module):Int
	fun delete(moduleId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<Module>
	fun readByModuleId(moduleId: Int):Module?
	fun readByModuleName(moduleName: String):MutableList<Module>
	fun readByModuleDescription(moduleDescription: String):MutableList<Module>
	fun readByModuleStatus(moduleStatus: String):MutableList<Module>
	fun readByModuleCreatedAt(moduleCreatedAt: String):MutableList<Module>
	fun readByModuleUpdatedAt(moduleUpdatedAt: String):MutableList<Module>
}

@Repository
class ModuleRepositoryImpl(private val environment: Environment): ModuleRepository{
   	override fun create(module:Module):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ModuleQuery.INSERT)
			.bind(module)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(modules:List<Module>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(ModuleQuery.INSERT, false)
			for (module in modules)
				query?.bind(module)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(module:Module):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ModuleQuery.UPDATE)
		.bind(module)
		.executeUpdate().result
	}

	override fun delete(moduleId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ModuleQuery.DELETE)
		.addParameter("moduleId", moduleId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(ModuleQuery.TRUNCATE)
	}

	override fun read():MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(ModuleQuery.READ)
		.executeAndFetch(Module::class.java)
	}

	override fun readByModuleId(moduleId: Int):Module?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_ID)
				.addParameter("moduleId", moduleId)
				.executeAndFetch(Module::class.java).firstOrNull()
	}

	override fun readByModuleName(moduleName: String):MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_NAME)
				.addParameter("moduleName", moduleName)
				.executeAndFetch(Module::class.java)
	}

	override fun readByModuleDescription(moduleDescription: String):MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_DESCRIPTION)
				.addParameter("moduleDescription", moduleDescription)
				.executeAndFetch(Module::class.java)
	}

	override fun readByModuleStatus(moduleStatus: String):MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_STATUS)
				.addParameter("moduleStatus", moduleStatus)
				.executeAndFetch(Module::class.java)
	}

	override fun readByModuleCreatedAt(moduleCreatedAt: String):MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_CREATED_AT)
				.addParameter("moduleCreatedAt", moduleCreatedAt)
				.executeAndFetch(Module::class.java)
	}

	override fun readByModuleUpdatedAt(moduleUpdatedAt: String):MutableList<Module>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(ModuleQuery.READ_BY_MODULE_UPDATED_AT)
				.addParameter("moduleUpdatedAt", moduleUpdatedAt)
				.executeAndFetch(Module::class.java)
	}
}
