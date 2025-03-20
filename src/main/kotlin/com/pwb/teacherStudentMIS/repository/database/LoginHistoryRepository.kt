//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.814741700
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.LoginHistory
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.LoginHistoryQuery
import org.springframework.stereotype.Repository



@Repository
interface LoginHistoryRepository{
   	fun create(loginHistory:LoginHistory):Long
	fun bulkCreate(loginHistorys:List<LoginHistory>)
	fun update(loginHistory:LoginHistory):Int
	fun delete(loginHistoryId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<LoginHistory>
	fun readByLoginHistoryId(loginHistoryId: Int):LoginHistory?
	fun readByLoginHistoryUsername(loginHistoryUsername: String):MutableList<LoginHistory>
	fun readByLoginHistoryIpAddress(loginHistoryIpAddress: String):MutableList<LoginHistory>
	fun readByLoginHistoryDeviceId(loginHistoryDeviceId: String):MutableList<LoginHistory>
	fun readByLoginHistoryLongitude(loginHistoryLongitude: String):MutableList<LoginHistory>
	fun readByLoginHistoryLatitude(loginHistoryLatitude: String):MutableList<LoginHistory>
	fun readByLoginHistoryStatus(loginHistoryStatus: String):MutableList<LoginHistory>
	fun readByLoginHistoryCreatedAt(loginHistoryCreatedAt: String):MutableList<LoginHistory>
	fun readByLoginHistoryUpdatedAt(loginHistoryUpdatedAt: String):MutableList<LoginHistory>
}

@Repository
class LoginHistoryRepositoryImpl(private val environment: Environment): LoginHistoryRepository{
   	override fun create(loginHistory:LoginHistory):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(LoginHistoryQuery.INSERT)
			.bind(loginHistory)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(loginHistorys:List<LoginHistory>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(LoginHistoryQuery.INSERT, false)
			for (loginHistory in loginHistorys)
				query?.bind(loginHistory)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(loginHistory:LoginHistory):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(LoginHistoryQuery.UPDATE)
		.bind(loginHistory)
		.executeUpdate().result
	}

	override fun delete(loginHistoryId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(LoginHistoryQuery.DELETE)
		.addParameter("loginHistoryId", loginHistoryId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(LoginHistoryQuery.TRUNCATE)
	}

	override fun read():MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ)
		.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryId(loginHistoryId: Int):LoginHistory?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_ID)
				.addParameter("loginHistoryId", loginHistoryId)
				.executeAndFetch(LoginHistory::class.java).firstOrNull()
	}

	override fun readByLoginHistoryUsername(loginHistoryUsername: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_USERNAME)
				.addParameter("loginHistoryUsername", loginHistoryUsername)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryIpAddress(loginHistoryIpAddress: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_IP_ADDRESS)
				.addParameter("loginHistoryIpAddress", loginHistoryIpAddress)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryDeviceId(loginHistoryDeviceId: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_DEVICE_ID)
				.addParameter("loginHistoryDeviceId", loginHistoryDeviceId)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryLongitude(loginHistoryLongitude: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LONGITUDE)
				.addParameter("loginHistoryLongitude", loginHistoryLongitude)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryLatitude(loginHistoryLatitude: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LATITUDE)
				.addParameter("loginHistoryLatitude", loginHistoryLatitude)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryStatus(loginHistoryStatus: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_STATUS)
				.addParameter("loginHistoryStatus", loginHistoryStatus)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryCreatedAt(loginHistoryCreatedAt: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_CREATED_AT)
				.addParameter("loginHistoryCreatedAt", loginHistoryCreatedAt)
				.executeAndFetch(LoginHistory::class.java)
	}

	override fun readByLoginHistoryUpdatedAt(loginHistoryUpdatedAt: String):MutableList<LoginHistory>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(LoginHistoryQuery.READ_BY_LOGIN_HISTORY_UPDATED_AT)
				.addParameter("loginHistoryUpdatedAt", loginHistoryUpdatedAt)
				.executeAndFetch(LoginHistory::class.java)
	}
}
