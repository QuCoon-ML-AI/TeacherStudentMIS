//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.783477800
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.classRepository
import com.pwb.teacherStudentMIS.model.entity.class
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class ClassService(
   private val classRepository: ClassRepository
){
   	fun create(request:ClassCreateRequest):BaseResponse{
		val class = GSON.fromJson(GSON.toJson(request), Class::class.java).apply { classStatus = classStatus?:"ACTIVE" }
		classRepository.create(class)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<ClassCreateRequest>):BaseResponse{
		val classs = GSON.fromJson(GSON.toJson(request), Array<Class>::class.java).toList()
		classRepository.bulkCreate(classs)
		return ResponseConstant.SUCCESS
	}

	fun update(request:ClassUpdateRequest):BaseResponse{
		var class = classRepository.readByClassId(request.classId!!)
			?:throw UnableToLocateRecordException()
		class = class.apply{
				classId = request.classId?:classId
				className = request.className?:className
				classTeacherId = request.classTeacherId?:classTeacherId
				classStatus = request.classStatus?:classStatus
			}
		classRepository.update(class)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:ClassDeleteRequest):BaseResponse{
		var updateResponse = classRepository.delete(request.classId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():classReadListResponse{
		var class = classRepository.read()
		return classReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassId(classId:Int): ClassReadSingleResponse{
		var class = classRepository.readByClassId(classId) 
			?: throw UnableToLocateRecordException()
		return ClassReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassName(className:String): ClassReadListResponse{
		var class = classRepository.readByClassName(className) 
		return ClassReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassTeacherId(classTeacherId:Int): ClassReadListResponse{
		var class = classRepository.readByClassTeacherId(classTeacherId) 
		return ClassReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassStatus(classStatus:String): ClassReadListResponse{
		var class = classRepository.readByClassStatus(classStatus) 
		return ClassReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassCreatedAt(classCreatedAt:String): ClassReadListResponse{
		var class = classRepository.readByClassCreatedAt(classCreatedAt) 
		return ClassReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

	fun readByClassUpdatedAt(classUpdatedAt:String): ClassReadListResponse{
		var class = classRepository.readByClassUpdatedAt(classUpdatedAt) 
		return ClassReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = class
		)
	}

}
