//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.845997800
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.PrivilegeRepository
import com.pwb.teacherStudentMIS.model.entity.Privilege
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class PrivilegeService(
   private val privilegeRepository: PrivilegeRepository
){
   	fun create(request:PrivilegeCreateRequest):BaseResponse{
		val privilege = GSON.fromJson(GSON.toJson(request), Privilege::class.java).apply { privilegeStatus = privilegeStatus?:"ACTIVE" }
		privilegeRepository.create(privilege)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<PrivilegeCreateRequest>):BaseResponse{
		val privileges = GSON.fromJson(GSON.toJson(request), Array<Privilege>::class.java).toList()
		privilegeRepository.bulkCreate(privileges)
		return ResponseConstant.SUCCESS
	}

	fun update(request:PrivilegeUpdateRequest):BaseResponse{
		var privilege = privilegeRepository.readByPrivilegeId(request.privilegeId!!)
			?:throw UnableToLocateRecordException()
		privilege = privilege.apply{
				privilegeId = request.privilegeId?:privilegeId
				privilegeCode = request.privilegeCode?:privilegeCode
				privilegeName = request.privilegeName?:privilegeName
				privilegeModuleName = request.privilegeModuleName?:privilegeModuleName
				privilegeDescription = request.privilegeDescription?:privilegeDescription
				privilegeStatus = request.privilegeStatus?:privilegeStatus
			}
		privilegeRepository.update(privilege)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:PrivilegeDeleteRequest):BaseResponse{
		var updateResponse = privilegeRepository.delete(request.privilegeId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():PrivilegeReadListResponse{
		var privilege = privilegeRepository.read()
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeId(privilegeId:Int): PrivilegeReadSingleResponse{
		var privilege = privilegeRepository.readByPrivilegeId(privilegeId) 
			?: throw UnableToLocateRecordException()
		return PrivilegeReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeCode(privilegeCode:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeCode(privilegeCode) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeName(privilegeName:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeName(privilegeName) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeModuleName(privilegeModuleName:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeModuleName(privilegeModuleName) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeDescription(privilegeDescription:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeDescription(privilegeDescription) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeStatus(privilegeStatus:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeStatus(privilegeStatus) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeCreatedAt(privilegeCreatedAt:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeCreatedAt(privilegeCreatedAt) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

	fun readByPrivilegeUpdatedAt(privilegeUpdatedAt:String): PrivilegeReadListResponse{
		var privilege = privilegeRepository.readByPrivilegeUpdatedAt(privilegeUpdatedAt) 
		return PrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = privilege
		)
	}

}
