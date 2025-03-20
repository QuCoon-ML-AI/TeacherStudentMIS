//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.799246600
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.UserOtpRepository
import com.pwb.teacherStudentMIS.model.entity.UserOtp
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class UserOtpService(
   private val userOtpRepository: UserOtpRepository
){
   	fun create(request:UserOtpCreateRequest):BaseResponse{
		val userOtp = GSON.fromJson(GSON.toJson(request), UserOtp::class.java).apply { userOtpStatus = userOtpStatus?:"ACTIVE" }
		userOtpRepository.create(userOtp)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<UserOtpCreateRequest>):BaseResponse{
		val userOtps = GSON.fromJson(GSON.toJson(request), Array<UserOtp>::class.java).toList()
		userOtpRepository.bulkCreate(userOtps)
		return ResponseConstant.SUCCESS
	}

	fun update(request:UserOtpUpdateRequest):BaseResponse{
		var userOtp = userOtpRepository.readByUserOtpId(request.userOtpId!!)
			?:throw UnableToLocateRecordException()
		userOtp = userOtp.apply{
				userOtpId = request.userOtpId?:userOtpId
				userOtpUsername = request.userOtpUsername?:userOtpUsername
				userOtpOtp = request.userOtpOtp?:userOtpOtp
				userOtpStatus = request.userOtpStatus?:userOtpStatus
			}
		userOtpRepository.update(userOtp)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:UserOtpDeleteRequest):BaseResponse{
		var updateResponse = userOtpRepository.delete(request.userOtpId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():UserOtpReadListResponse{
		var userOtp = userOtpRepository.read()
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpId(userOtpId:Int): UserOtpReadSingleResponse{
		var userOtp = userOtpRepository.readByUserOtpId(userOtpId) 
			?: throw UnableToLocateRecordException()
		return UserOtpReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpUsername(userOtpUsername:String): UserOtpReadListResponse{
		var userOtp = userOtpRepository.readByUserOtpUsername(userOtpUsername) 
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpOtp(userOtpOtp:String): UserOtpReadListResponse{
		var userOtp = userOtpRepository.readByUserOtpOtp(userOtpOtp) 
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpStatus(userOtpStatus:String): UserOtpReadListResponse{
		var userOtp = userOtpRepository.readByUserOtpStatus(userOtpStatus) 
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpCreatedAt(userOtpCreatedAt:String): UserOtpReadListResponse{
		var userOtp = userOtpRepository.readByUserOtpCreatedAt(userOtpCreatedAt) 
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

	fun readByUserOtpUpdatedAt(userOtpUpdatedAt:String): UserOtpReadListResponse{
		var userOtp = userOtpRepository.readByUserOtpUpdatedAt(userOtpUpdatedAt) 
		return UserOtpReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = userOtp
		)
	}

}
