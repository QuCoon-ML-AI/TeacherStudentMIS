//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.908509300
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.AuditLogRepository
import com.pwb.teacherStudentMIS.model.entity.AuditLog
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class AuditLogService(
   private val auditLogRepository: AuditLogRepository
){
   	fun create(request:AuditLogCreateRequest):BaseResponse{
		val auditLog = GSON.fromJson(GSON.toJson(request), AuditLog::class.java).apply { auditLogStatus = auditLogStatus?:"ACTIVE" }
		auditLogRepository.create(auditLog)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<AuditLogCreateRequest>):BaseResponse{
		val auditLogs = GSON.fromJson(GSON.toJson(request), Array<AuditLog>::class.java).toList()
		auditLogRepository.bulkCreate(auditLogs)
		return ResponseConstant.SUCCESS
	}

	fun update(request:AuditLogUpdateRequest):BaseResponse{
		var auditLog = auditLogRepository.readByAuditLogId(request.auditLogId!!)
			?:throw UnableToLocateRecordException()
		auditLog = auditLog.apply{
				auditLogId = request.auditLogId?:auditLogId
				auditLogAction = request.auditLogAction?:auditLogAction
				auditLogRequest = request.auditLogRequest?:auditLogRequest
				auditLogResponse = request.auditLogResponse?:auditLogResponse
				auditLogModule = request.auditLogModule?:auditLogModule
				auditLogResponseCode = request.auditLogResponseCode?:auditLogResponseCode
				auditLogResponseMessage = request.auditLogResponseMessage?:auditLogResponseMessage
				auditLogStatus = request.auditLogStatus?:auditLogStatus
			}
		auditLogRepository.update(auditLog)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:AuditLogDeleteRequest):BaseResponse{
		var updateResponse = auditLogRepository.delete(request.auditLogId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():AuditLogReadListResponse{
		var auditLog = auditLogRepository.read()
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogId(auditLogId:Int): AuditLogReadSingleResponse{
		var auditLog = auditLogRepository.readByAuditLogId(auditLogId) 
			?: throw UnableToLocateRecordException()
		return AuditLogReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogUserId(auditLogUserId:Int): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogUserId(auditLogUserId) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogAction(auditLogAction:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogAction(auditLogAction) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogRequest(auditLogRequest:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogRequest(auditLogRequest) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogResponse(auditLogResponse:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogResponse(auditLogResponse) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogModule(auditLogModule:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogModule(auditLogModule) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogResponseCode(auditLogResponseCode:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogResponseCode(auditLogResponseCode) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogResponseMessage(auditLogResponseMessage:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogResponseMessage(auditLogResponseMessage) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogStatus(auditLogStatus:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogStatus(auditLogStatus) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogCreatedAt(auditLogCreatedAt:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogCreatedAt(auditLogCreatedAt) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

	fun readByAuditLogUpdatedAt(auditLogUpdatedAt:String): AuditLogReadListResponse{
		var auditLog = auditLogRepository.readByAuditLogUpdatedAt(auditLogUpdatedAt) 
		return AuditLogReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = auditLog
		)
	}

}
