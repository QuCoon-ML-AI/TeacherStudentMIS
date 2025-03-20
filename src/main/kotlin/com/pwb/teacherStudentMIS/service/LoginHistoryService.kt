//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.814741700
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.LoginHistoryRepository
import com.pwb.teacherStudentMIS.model.entity.LoginHistory
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class LoginHistoryService(
   private val loginHistoryRepository: LoginHistoryRepository
){
   	fun create(request:LoginHistoryCreateRequest):BaseResponse{
		val loginHistory = GSON.fromJson(GSON.toJson(request), LoginHistory::class.java).apply { loginHistoryStatus = loginHistoryStatus?:"ACTIVE" }
		loginHistoryRepository.create(loginHistory)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<LoginHistoryCreateRequest>):BaseResponse{
		val loginHistorys = GSON.fromJson(GSON.toJson(request), Array<LoginHistory>::class.java).toList()
		loginHistoryRepository.bulkCreate(loginHistorys)
		return ResponseConstant.SUCCESS
	}

	fun update(request:LoginHistoryUpdateRequest):BaseResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryId(request.loginHistoryId!!)
			?:throw UnableToLocateRecordException()
		loginHistory = loginHistory.apply{
				loginHistoryId = request.loginHistoryId?:loginHistoryId
				loginHistoryUsername = request.loginHistoryUsername?:loginHistoryUsername
				loginHistoryIpAddress = request.loginHistoryIpAddress?:loginHistoryIpAddress
				loginHistoryDeviceId = request.loginHistoryDeviceId?:loginHistoryDeviceId
				loginHistoryLongitude = request.loginHistoryLongitude?:loginHistoryLongitude
				loginHistoryLatitude = request.loginHistoryLatitude?:loginHistoryLatitude
				loginHistoryStatus = request.loginHistoryStatus?:loginHistoryStatus
			}
		loginHistoryRepository.update(loginHistory)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:LoginHistoryDeleteRequest):BaseResponse{
		var updateResponse = loginHistoryRepository.delete(request.loginHistoryId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.read()
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryId(loginHistoryId:Int): LoginHistoryReadSingleResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryId(loginHistoryId) 
			?: throw UnableToLocateRecordException()
		return LoginHistoryReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryUsername(loginHistoryUsername:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryUsername(loginHistoryUsername) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryIpAddress(loginHistoryIpAddress:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryIpAddress(loginHistoryIpAddress) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryDeviceId(loginHistoryDeviceId:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryDeviceId(loginHistoryDeviceId) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryLongitude(loginHistoryLongitude:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryLongitude(loginHistoryLongitude) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryLatitude(loginHistoryLatitude:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryLatitude(loginHistoryLatitude) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryStatus(loginHistoryStatus:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryStatus(loginHistoryStatus) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryCreatedAt(loginHistoryCreatedAt:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryCreatedAt(loginHistoryCreatedAt) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

	fun readByLoginHistoryUpdatedAt(loginHistoryUpdatedAt:String): LoginHistoryReadListResponse{
		var loginHistory = loginHistoryRepository.readByLoginHistoryUpdatedAt(loginHistoryUpdatedAt) 
		return LoginHistoryReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = loginHistory
		)
	}

}
