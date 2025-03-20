//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.studentRepository
import com.pwb.teacherStudentMIS.model.entity.student
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class StudentService(
   private val studentRepository: StudentRepository
){
   	fun create(request:StudentCreateRequest):BaseResponse{
		val student = GSON.fromJson(GSON.toJson(request), Student::class.java).apply { studentStatus = studentStatus?:"ACTIVE" }
		studentRepository.create(student)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<StudentCreateRequest>):BaseResponse{
		val students = GSON.fromJson(GSON.toJson(request), Array<Student>::class.java).toList()
		studentRepository.bulkCreate(students)
		return ResponseConstant.SUCCESS
	}

	fun update(request:StudentUpdateRequest):BaseResponse{
		var student = studentRepository.readByStudentId(request.studentId!!)
			?:throw UnableToLocateRecordException()
		student = student.apply{
				studentId = request.studentId?:studentId
				studentName = request.studentName?:studentName
				studentGrade = request.studentGrade?:studentGrade
				studentStatus = request.studentStatus?:studentStatus
			}
		studentRepository.update(student)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:StudentDeleteRequest):BaseResponse{
		var updateResponse = studentRepository.delete(request.studentId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():studentReadListResponse{
		var student = studentRepository.read()
		return studentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentId(studentId:Int): StudentReadSingleResponse{
		var student = studentRepository.readByStudentId(studentId) 
			?: throw UnableToLocateRecordException()
		return StudentReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentName(studentName:String): StudentReadListResponse{
		var student = studentRepository.readByStudentName(studentName) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentGrade(studentGrade:String): StudentReadListResponse{
		var student = studentRepository.readByStudentGrade(studentGrade) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentStatus(studentStatus:String): StudentReadListResponse{
		var student = studentRepository.readByStudentStatus(studentStatus) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentCreatedAt(studentCreatedAt:String): StudentReadListResponse{
		var student = studentRepository.readByStudentCreatedAt(studentCreatedAt) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentUpdatedAt(studentUpdatedAt:String): StudentReadListResponse{
		var student = studentRepository.readByStudentUpdatedAt(studentUpdatedAt) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

}
