//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.799246600
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
@RequestMapping("/{stage}/user-otp")
class UserOtpController(
	private val userOtpService: UserOtpService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserOtpCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return userOtpService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<UserOtpCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return userOtpService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserOtpUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return userOtpService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserOtpDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return userOtpService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.read()
	}

	@GetMapping("/read-by-user-otp-id/{userOtpId}")
	fun readByUserOtpId(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpId:Int, @PathVariable stage: String):UserOtpReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpId(userOtpId)
	}

	@GetMapping("/read-by-user-otp-username/{userOtpUsername}")
	fun readByUserOtpUsername(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpUsername:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpUsername(userOtpUsername)
	}

	@GetMapping("/read-by-user-otp-otp/{userOtpOtp}")
	fun readByUserOtpOtp(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpOtp:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpOtp(userOtpOtp)
	}

	@GetMapping("/read-by-user-otp-status/{userOtpStatus}")
	fun readByUserOtpStatus(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpStatus:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpStatus(userOtpStatus)
	}

	@GetMapping("/read-by-user-otp-created-at/{userOtpCreatedAt}")
	fun readByUserOtpCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpCreatedAt:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpCreatedAt(userOtpCreatedAt)
	}

	@GetMapping("/read-by-user-otp-updated-at/{userOtpUpdatedAt}")
	fun readByUserOtpUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable userOtpUpdatedAt:String, @PathVariable stage: String):UserOtpReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userOtpService.readByUserOtpUpdatedAt(userOtpUpdatedAt)
	}

}
