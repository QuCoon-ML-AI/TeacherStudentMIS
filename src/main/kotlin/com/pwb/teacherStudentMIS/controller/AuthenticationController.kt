//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.970990200
package com.pwb.teacherStudentMIS.controller

import com.pwb.teacherStudentMIS.service.AuthenticationService
import org.pwb.utility.model.response.BaseResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.pwb.teacherStudentMIS.utility.constant.*
import com.pwb.teacherStudentMIS.utility.*
import org.pwb.utility.model.request.ModulePrivilege
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.general.camelToSnakeCase


@RestController
@RequestMapping("/{stage}/authentication")
class AuthenticationController(
	private val authenticationService: AuthenticationService,
	private val environment: Environment
){
   	@PostMapping("/initiate-enrollment")
	fun initiateEnrollment(@Valid @RequestBody request:InitiateEnrollmentRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.initiateEnrollment(request)
	}

	@PostMapping("/complete-enrollment")
	fun completeEnrollment(@Valid @RequestBody request:CompleteEnrollmentRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.completeEnrollment(request)
	}

	@PostMapping("/login")
	fun login(@Valid @RequestBody request:LoginRequest, @PathVariable stage: String):LoginResponse{
		return authenticationService.login(request)
	}

	@PostMapping("/initiate-password-reset")
	fun initiatePasswordReset(@Valid @RequestBody request:InitiatePasswordResetRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.initiatePasswordReset(request)
	}

	@PostMapping("/complete-password-reset")
	fun completePasswordReset(@Valid @RequestBody request:CompletePasswordResetRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.completePasswordReset(request)
	}

	@PostMapping("/change-password")
	fun changePassword(@Valid @RequestBody request:ChangePasswordRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.changePassword(request)
	}

	@PostMapping("/resend-otp")
	fun resendOtp(@Valid @RequestBody request:InitiatePasswordResetRequest, @PathVariable stage: String):BaseResponse{
		return authenticationService.resendOtp(request)
	}

	@GetMapping("/user-details")
	fun userDetails(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):LoginResponse{
		return environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.ALL),
			authorization)
	}

	@GetMapping("/load-config")
	fun loadAppConfig(@PathVariable stage: String):BaseResponse{
		return authenticationService.loadAppConfig()
	}

}
