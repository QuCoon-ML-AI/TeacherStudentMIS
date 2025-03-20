//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.teacherRepository
import com.pwb.teacherStudentMIS.model.entity.teacher
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class TeacherService(
   private val teacherRepository: TeacherRepository
){
   	fun create(request:TeacherCreateRequest):BaseResponse{
		val teacher = GSON.fromJson(GSON.toJson(request), Teacher::class.java).apply { teacherStatus = teacherStatus?:"ACTIVE" }
		teacherRepository.create(teacher)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<TeacherCreateRequest>):BaseResponse{
		val teachers = GSON.fromJson(GSON.toJson(request), Array<Teacher>::class.java).toList()
		teacherRepository.bulkCreate(teachers)
		return ResponseConstant.SUCCESS
	}

	fun update(request:TeacherUpdateRequest):BaseResponse{
		var teacher = teacherRepository.readByTeacherId(request.teacherId!!)
			?:throw UnableToLocateRecordException()
		teacher = teacher.apply{
				teacherId = request.teacherId?:teacherId
				teacherEmail = request.teacherEmail?:teacherEmail
				teacherName = request.teacherName?:teacherName
				teacherStatus = request.teacherStatus?:teacherStatus
				teacherPassword = request.teacherPassword?:teacherPassword
			}
		teacherRepository.update(teacher)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:TeacherDeleteRequest):BaseResponse{
		var updateResponse = teacherRepository.delete(request.teacherId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():teacherReadListResponse{
		var teacher = teacherRepository.read()
		return teacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherId(teacherId:Int): TeacherReadSingleResponse{
		var teacher = teacherRepository.readByTeacherId(teacherId) 
			?: throw UnableToLocateRecordException()
		return TeacherReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherEmail(teacherEmail:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherEmail(teacherEmail) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherName(teacherName:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherName(teacherName) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherStatus(teacherStatus:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherStatus(teacherStatus) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherCreatedAt(teacherCreatedAt:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherCreatedAt(teacherCreatedAt) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherUpdatedAt(teacherUpdatedAt:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherUpdatedAt(teacherUpdatedAt) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

	fun readByTeacherPassword(teacherPassword:String): TeacherReadListResponse{
		var teacher = teacherRepository.readByTeacherPassword(teacherPassword) 
		return TeacherReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = teacher
		)
	}

}
