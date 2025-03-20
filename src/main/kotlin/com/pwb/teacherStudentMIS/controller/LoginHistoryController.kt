//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.830377400
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
@RequestMapping("/{stage}/login-history")
class LoginHistoryController(
	private val loginHistoryService: LoginHistoryService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:LoginHistoryCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return loginHistoryService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<LoginHistoryCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return loginHistoryService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:LoginHistoryUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return loginHistoryService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:LoginHistoryDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return loginHistoryService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.read()
	}

	@GetMapping("/read-by-login-history-id/{loginHistoryId}")
	fun readByLoginHistoryId(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryId:Int, @PathVariable stage: String):LoginHistoryReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryId(loginHistoryId)
	}

	@GetMapping("/read-by-login-history-username/{loginHistoryUsername}")
	fun readByLoginHistoryUsername(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryUsername:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryUsername(loginHistoryUsername)
	}

	@GetMapping("/read-by-login-history-ip-address/{loginHistoryIpAddress}")
	fun readByLoginHistoryIpAddress(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryIpAddress:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryIpAddress(loginHistoryIpAddress)
	}

	@GetMapping("/read-by-login-history-device-id/{loginHistoryDeviceId}")
	fun readByLoginHistoryDeviceId(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryDeviceId:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryDeviceId(loginHistoryDeviceId)
	}

	@GetMapping("/read-by-login-history-longitude/{loginHistoryLongitude}")
	fun readByLoginHistoryLongitude(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryLongitude:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryLongitude(loginHistoryLongitude)
	}

	@GetMapping("/read-by-login-history-latitude/{loginHistoryLatitude}")
	fun readByLoginHistoryLatitude(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryLatitude:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryLatitude(loginHistoryLatitude)
	}

	@GetMapping("/read-by-login-history-status/{loginHistoryStatus}")
	fun readByLoginHistoryStatus(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryStatus:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryStatus(loginHistoryStatus)
	}

	@GetMapping("/read-by-login-history-created-at/{loginHistoryCreatedAt}")
	fun readByLoginHistoryCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryCreatedAt:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryCreatedAt(loginHistoryCreatedAt)
	}

	@GetMapping("/read-by-login-history-updated-at/{loginHistoryUpdatedAt}")
	fun readByLoginHistoryUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable loginHistoryUpdatedAt:String, @PathVariable stage: String):LoginHistoryReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return loginHistoryService.readByLoginHistoryUpdatedAt(loginHistoryUpdatedAt)
	}

}
