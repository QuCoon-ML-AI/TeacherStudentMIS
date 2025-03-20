//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.RoleRepository
import com.pwb.teacherStudentMIS.model.entity.Role
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class RoleService(
   private val roleRepository: RoleRepository
){
   	fun create(request:RoleCreateRequest):BaseResponse{
		val role = GSON.fromJson(GSON.toJson(request), Role::class.java).apply { roleStatus = roleStatus?:"ACTIVE" }
		roleRepository.create(role)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<RoleCreateRequest>):BaseResponse{
		val roles = GSON.fromJson(GSON.toJson(request), Array<Role>::class.java).toList()
		roleRepository.bulkCreate(roles)
		return ResponseConstant.SUCCESS
	}

	fun update(request:RoleUpdateRequest):BaseResponse{
		var role = roleRepository.readByRoleId(request.roleId!!)
			?:throw UnableToLocateRecordException()
		role = role.apply{
				roleId = request.roleId?:roleId
				roleName = request.roleName?:roleName
				roleDescription = request.roleDescription?:roleDescription
				roleIsPublic = request.roleIsPublic?:roleIsPublic
				roleStatus = request.roleStatus?:roleStatus
			}
		roleRepository.update(role)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:RoleDeleteRequest):BaseResponse{
		var updateResponse = roleRepository.delete(request.roleId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():RoleReadListResponse{
		var role = roleRepository.read()
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleId(roleId:Int): RoleReadSingleResponse{
		var role = roleRepository.readByRoleId(roleId) 
			?: throw UnableToLocateRecordException()
		return RoleReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleName(roleName:String): RoleReadListResponse{
		var role = roleRepository.readByRoleName(roleName) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleDescription(roleDescription:String): RoleReadListResponse{
		var role = roleRepository.readByRoleDescription(roleDescription) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleIsPublic(roleIsPublic:String): RoleReadListResponse{
		var role = roleRepository.readByRoleIsPublic(roleIsPublic) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleStatus(roleStatus:String): RoleReadListResponse{
		var role = roleRepository.readByRoleStatus(roleStatus) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleCreatedAt(roleCreatedAt:String): RoleReadListResponse{
		var role = roleRepository.readByRoleCreatedAt(roleCreatedAt) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

	fun readByRoleUpdatedAt(roleUpdatedAt:String): RoleReadListResponse{
		var role = roleRepository.readByRoleUpdatedAt(roleUpdatedAt) 
		return RoleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = role
		)
	}

}
