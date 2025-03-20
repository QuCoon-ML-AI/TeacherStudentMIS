//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.908509300
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
@RequestMapping("/{stage}/audit-log")
class AuditLogController(
	private val auditLogService: AuditLogService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:AuditLogCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return auditLogService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<AuditLogCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return auditLogService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:AuditLogUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return auditLogService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:AuditLogDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return auditLogService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.read()
	}

	@GetMapping("/read-by-audit-log-id/{auditLogId}")
	fun readByAuditLogId(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogId:Int, @PathVariable stage: String):AuditLogReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogId(auditLogId)
	}

	@GetMapping("/read-by-audit-log-user-id/{auditLogUserId}")
	fun readByAuditLogUserId(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogUserId:Int, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogUserId(auditLogUserId)
	}

	@GetMapping("/read-by-audit-log-action/{auditLogAction}")
	fun readByAuditLogAction(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogAction:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogAction(auditLogAction)
	}

	@GetMapping("/read-by-audit-log-request/{auditLogRequest}")
	fun readByAuditLogRequest(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogRequest:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogRequest(auditLogRequest)
	}

	@GetMapping("/read-by-audit-log-response/{auditLogResponse}")
	fun readByAuditLogResponse(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogResponse:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogResponse(auditLogResponse)
	}

	@GetMapping("/read-by-audit-log-module/{auditLogModule}")
	fun readByAuditLogModule(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogModule:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogModule(auditLogModule)
	}

	@GetMapping("/read-by-audit-log-response-code/{auditLogResponseCode}")
	fun readByAuditLogResponseCode(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogResponseCode:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogResponseCode(auditLogResponseCode)
	}

	@GetMapping("/read-by-audit-log-response-message/{auditLogResponseMessage}")
	fun readByAuditLogResponseMessage(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogResponseMessage:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogResponseMessage(auditLogResponseMessage)
	}

	@GetMapping("/read-by-audit-log-status/{auditLogStatus}")
	fun readByAuditLogStatus(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogStatus:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogStatus(auditLogStatus)
	}

	@GetMapping("/read-by-audit-log-created-at/{auditLogCreatedAt}")
	fun readByAuditLogCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogCreatedAt:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogCreatedAt(auditLogCreatedAt)
	}

	@GetMapping("/read-by-audit-log-updated-at/{auditLogUpdatedAt}")
	fun readByAuditLogUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable auditLogUpdatedAt:String, @PathVariable stage: String):AuditLogReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return auditLogService.readByAuditLogUpdatedAt(auditLogUpdatedAt)
	}

}
