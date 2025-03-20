//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.RolePrivilegeRepository
import com.pwb.teacherStudentMIS.model.entity.RolePrivilege
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class RolePrivilegeService(
   private val rolePrivilegeRepository: RolePrivilegeRepository
){
   	fun create(request:RolePrivilegeCreateRequest):BaseResponse{
		val rolePrivilege = GSON.fromJson(GSON.toJson(request), RolePrivilege::class.java).apply { rolePrivilegeStatus = rolePrivilegeStatus?:"ACTIVE" }
		rolePrivilegeRepository.create(rolePrivilege)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<RolePrivilegeCreateRequest>):BaseResponse{
		val rolePrivileges = GSON.fromJson(GSON.toJson(request), Array<RolePrivilege>::class.java).toList()
		rolePrivilegeRepository.bulkCreate(rolePrivileges)
		return ResponseConstant.SUCCESS
	}

	fun update(request:RolePrivilegeUpdateRequest):BaseResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeId(request.rolePrivilegeId!!)
			?:throw UnableToLocateRecordException()
		rolePrivilege = rolePrivilege.apply{
				rolePrivilegeId = request.rolePrivilegeId?:rolePrivilegeId
				rolePrivilegeRoleId = request.rolePrivilegeRoleId?:rolePrivilegeRoleId
				rolePrivilegePrivilegeCode = request.rolePrivilegePrivilegeCode?:rolePrivilegePrivilegeCode
				rolePrivilegeStatus = request.rolePrivilegeStatus?:rolePrivilegeStatus
			}
		rolePrivilegeRepository.update(rolePrivilege)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:RolePrivilegeDeleteRequest):BaseResponse{
		var updateResponse = rolePrivilegeRepository.delete(request.rolePrivilegeId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.read()
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegeId(rolePrivilegeId:Int): RolePrivilegeReadSingleResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeId(rolePrivilegeId) 
			?: throw UnableToLocateRecordException()
		return RolePrivilegeReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegeRoleId(rolePrivilegeRoleId:Int): RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeRoleId(rolePrivilegeRoleId) 
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegePrivilegeCode(rolePrivilegePrivilegeCode:String): RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegePrivilegeCode(rolePrivilegePrivilegeCode) 
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegeStatus(rolePrivilegeStatus:String): RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeStatus(rolePrivilegeStatus) 
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegeCreatedAt(rolePrivilegeCreatedAt:String): RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeCreatedAt(rolePrivilegeCreatedAt) 
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

	fun readByRolePrivilegeUpdatedAt(rolePrivilegeUpdatedAt:String): RolePrivilegeReadListResponse{
		var rolePrivilege = rolePrivilegeRepository.readByRolePrivilegeUpdatedAt(rolePrivilegeUpdatedAt) 
		return RolePrivilegeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = rolePrivilege
		)
	}

}
