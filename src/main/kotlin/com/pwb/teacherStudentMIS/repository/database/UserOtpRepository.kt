//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.799246600
package com.pwb.teacherStudentMIS.repository.database

import com.pwb.teacherStudentMIS.model.entity.UserOtp
import com.pwb.teacherStudentMIS.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.teacherStudentMIS.repository.database.query.UserOtpQuery
import org.springframework.stereotype.Repository



@Repository
interface UserOtpRepository{
   	fun create(userOtp:UserOtp):Long
	fun bulkCreate(userOtps:List<UserOtp>)
	fun update(userOtp:UserOtp):Int
	fun delete(userOtpId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<UserOtp>
	fun readByUserOtpId(userOtpId: Int):UserOtp?
	fun readByUserOtpUsername(userOtpUsername: String):MutableList<UserOtp>
	fun readByUserOtpOtp(userOtpOtp: String):MutableList<UserOtp>
	fun readByUserOtpStatus(userOtpStatus: String):MutableList<UserOtp>
	fun readByUserOtpCreatedAt(userOtpCreatedAt: String):MutableList<UserOtp>
	fun readByUserOtpUpdatedAt(userOtpUpdatedAt: String):MutableList<UserOtp>
}

@Repository
class UserOtpRepositoryImpl(private val environment: Environment): UserOtpRepository{
   	override fun create(userOtp:UserOtp):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserOtpQuery.INSERT)
			.bind(userOtp)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(userOtps:List<UserOtp>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(UserOtpQuery.INSERT, false)
			for (userOtp in userOtps)
				query?.bind(userOtp)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(userOtp:UserOtp):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserOtpQuery.UPDATE)
		.bind(userOtp)
		.executeUpdate().result
	}

	override fun delete(userOtpId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserOtpQuery.DELETE)
		.addParameter("userOtpId", userOtpId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(UserOtpQuery.TRUNCATE)
	}

	override fun read():MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserOtpQuery.READ)
		.executeAndFetch(UserOtp::class.java)
	}

	override fun readByUserOtpId(userOtpId: Int):UserOtp?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_ID)
				.addParameter("userOtpId", userOtpId)
				.executeAndFetch(UserOtp::class.java).firstOrNull()
	}

	override fun readByUserOtpUsername(userOtpUsername: String):MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_USERNAME)
				.addParameter("userOtpUsername", userOtpUsername)
				.executeAndFetch(UserOtp::class.java)
	}

	override fun readByUserOtpOtp(userOtpOtp: String):MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_OTP)
				.addParameter("userOtpOtp", userOtpOtp)
				.executeAndFetch(UserOtp::class.java)
	}

	override fun readByUserOtpStatus(userOtpStatus: String):MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_STATUS)
				.addParameter("userOtpStatus", userOtpStatus)
				.executeAndFetch(UserOtp::class.java)
	}

	override fun readByUserOtpCreatedAt(userOtpCreatedAt: String):MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_CREATED_AT)
				.addParameter("userOtpCreatedAt", userOtpCreatedAt)
				.executeAndFetch(UserOtp::class.java)
	}

	override fun readByUserOtpUpdatedAt(userOtpUpdatedAt: String):MutableList<UserOtp>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserOtpQuery.READ_BY_USER_OTP_UPDATED_AT)
				.addParameter("userOtpUpdatedAt", userOtpUpdatedAt)
				.executeAndFetch(UserOtp::class.java)
	}
}
