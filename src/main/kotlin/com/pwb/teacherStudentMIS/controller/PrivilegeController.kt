//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.845997800
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
@RequestMapping("/{stage}/privilege")
class PrivilegeController(
	private val privilegeService: PrivilegeService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PrivilegeCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return privilegeService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<PrivilegeCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return privilegeService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PrivilegeUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return privilegeService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PrivilegeDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return privilegeService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.read()
	}

	@GetMapping("/read-by-privilege-id/{privilegeId}")
	fun readByPrivilegeId(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeId:Int, @PathVariable stage: String):PrivilegeReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeId(privilegeId)
	}

	@GetMapping("/read-by-privilege-code/{privilegeCode}")
	fun readByPrivilegeCode(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeCode:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeCode(privilegeCode)
	}

	@GetMapping("/read-by-privilege-name/{privilegeName}")
	fun readByPrivilegeName(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeName:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeName(privilegeName)
	}

	@GetMapping("/read-by-privilege-module-name/{privilegeModuleName}")
	fun readByPrivilegeModuleName(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeModuleName:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeModuleName(privilegeModuleName)
	}

	@GetMapping("/read-by-privilege-description/{privilegeDescription}")
	fun readByPrivilegeDescription(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeDescription:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeDescription(privilegeDescription)
	}

	@GetMapping("/read-by-privilege-status/{privilegeStatus}")
	fun readByPrivilegeStatus(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeStatus:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeStatus(privilegeStatus)
	}

	@GetMapping("/read-by-privilege-created-at/{privilegeCreatedAt}")
	fun readByPrivilegeCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeCreatedAt:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeCreatedAt(privilegeCreatedAt)
	}

	@GetMapping("/read-by-privilege-updated-at/{privilegeUpdatedAt}")
	fun readByPrivilegeUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable privilegeUpdatedAt:String, @PathVariable stage: String):PrivilegeReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return privilegeService.readByPrivilegeUpdatedAt(privilegeUpdatedAt)
	}

}
