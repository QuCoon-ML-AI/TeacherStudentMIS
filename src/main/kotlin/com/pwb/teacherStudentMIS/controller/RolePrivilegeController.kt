//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.controller

import com.pwb.teacherStudentMIS.service.*
import org.pwb.utility.model.response.BaseResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.BadRequestException
import org.pwb.utility.exception.ActivityAlreadyPerformedException
import org.pwb.utility.general.camelToSnakeCase
import org.pwb.utility.constant.*
import com.pwb.teacherStudentMIS.utility.constant.*
import com.pwb.teacherStudentMIS.utility.*
import org.pwb.utility.model.request.ModulePrivilege


@RestController
@RequestMapping("/{stage}/role-privilege")
class RolePrivilegeController(
	private val rolePrivilegeService: RolePrivilegeService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RolePrivilegeCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return rolePrivilegeService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<RolePrivilegeCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return rolePrivilegeService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RolePrivilegeUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return rolePrivilegeService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RolePrivilegeDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return rolePrivilegeService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.read()
	}

	@GetMapping("/read-by-role-privilege-id/{rolePrivilegeId}")
	fun readByRolePrivilegeId(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegeId:Int, @PathVariable stage: String):RolePrivilegeReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegeId(rolePrivilegeId)
	}

	@GetMapping("/read-by-role-privilege-role-id/{rolePrivilegeRoleId}")
	fun readByRolePrivilegeRoleId(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegeRoleId:Int, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegeRoleId(rolePrivilegeRoleId)
	}

	@GetMapping("/read-by-role-privilege-privilege-code/{rolePrivilegePrivilegeCode}")
	fun readByRolePrivilegePrivilegeCode(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegePrivilegeCode:String, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegePrivilegeCode(rolePrivilegePrivilegeCode)
	}

	@GetMapping("/read-by-role-privilege-status/{rolePrivilegeStatus}")
	fun readByRolePrivilegeStatus(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegeStatus:String, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegeStatus(rolePrivilegeStatus)
	}

	@GetMapping("/read-by-role-privilege-created-at/{rolePrivilegeCreatedAt}")
	fun readByRolePrivilegeCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegeCreatedAt:String, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegeCreatedAt(rolePrivilegeCreatedAt)
	}

	@GetMapping("/read-by-role-privilege-updated-at/{rolePrivilegeUpdatedAt}")
	fun readByRolePrivilegeUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable rolePrivilegeUpdatedAt:String, @PathVariable stage: String):RolePrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return rolePrivilegeService.readByRolePrivilegeUpdatedAt(rolePrivilegeUpdatedAt)
	}

}
