//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
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
@RequestMapping("/{stage}/student")
class StudentController(
	private val studentService: StudentService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:StudentCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return studentService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<StudentCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return studentService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:StudentUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return studentService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:StudentDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return studentService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):studentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.read()
	}

	@GetMapping("/read-by-student-id/{studentId}")
	fun readByStudentId(@RequestHeader("Authorization") authorization:String, @PathVariable studentId:Int, @PathVariable stage: String):StudentReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentId(studentId)
	}

	@GetMapping("/read-by-student-name/{studentName}")
	fun readByStudentName(@RequestHeader("Authorization") authorization:String, @PathVariable studentName:String, @PathVariable stage: String):StudentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentName(studentName)
	}

	@GetMapping("/read-by-student-grade/{studentGrade}")
	fun readByStudentGrade(@RequestHeader("Authorization") authorization:String, @PathVariable studentGrade:String, @PathVariable stage: String):StudentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentGrade(studentGrade)
	}

	@GetMapping("/read-by-student-status/{studentStatus}")
	fun readByStudentStatus(@RequestHeader("Authorization") authorization:String, @PathVariable studentStatus:String, @PathVariable stage: String):StudentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentStatus(studentStatus)
	}

	@GetMapping("/read-by-student-created-at/{studentCreatedAt}")
	fun readByStudentCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable studentCreatedAt:String, @PathVariable stage: String):StudentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentCreatedAt(studentCreatedAt)
	}

	@GetMapping("/read-by-student-updated-at/{studentUpdatedAt}")
	fun readByStudentUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable studentUpdatedAt:String, @PathVariable stage: String):StudentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return studentService.readByStudentUpdatedAt(studentUpdatedAt)
	}

}
