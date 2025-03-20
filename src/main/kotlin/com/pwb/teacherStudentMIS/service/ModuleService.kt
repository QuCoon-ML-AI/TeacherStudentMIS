//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.service

import com.pwb.teacherStudentMIS.repository.database.ModuleRepository
import com.pwb.teacherStudentMIS.model.entity.Module
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.teacherStudentMIS.model.response.*
import com.pwb.teacherStudentMIS.model.request.*
import org.pwb.utility.exception.*


@Service
class ModuleService(
   private val moduleRepository: ModuleRepository
){
   	fun create(request:ModuleCreateRequest):BaseResponse{
		val module = GSON.fromJson(GSON.toJson(request), Module::class.java).apply { moduleStatus = moduleStatus?:"ACTIVE" }
		moduleRepository.create(module)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<ModuleCreateRequest>):BaseResponse{
		val modules = GSON.fromJson(GSON.toJson(request), Array<Module>::class.java).toList()
		moduleRepository.bulkCreate(modules)
		return ResponseConstant.SUCCESS
	}

	fun update(request:ModuleUpdateRequest):BaseResponse{
		var module = moduleRepository.readByModuleId(request.moduleId!!)
			?:throw UnableToLocateRecordException()
		module = module.apply{
				moduleId = request.moduleId?:moduleId
				moduleName = request.moduleName?:moduleName
				moduleDescription = request.moduleDescription?:moduleDescription
				moduleStatus = request.moduleStatus?:moduleStatus
			}
		moduleRepository.update(module)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:ModuleDeleteRequest):BaseResponse{
		var updateResponse = moduleRepository.delete(request.moduleId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():ModuleReadListResponse{
		var module = moduleRepository.read()
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleId(moduleId:Int): ModuleReadSingleResponse{
		var module = moduleRepository.readByModuleId(moduleId) 
			?: throw UnableToLocateRecordException()
		return ModuleReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleName(moduleName:String): ModuleReadListResponse{
		var module = moduleRepository.readByModuleName(moduleName) 
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleDescription(moduleDescription:String): ModuleReadListResponse{
		var module = moduleRepository.readByModuleDescription(moduleDescription) 
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleStatus(moduleStatus:String): ModuleReadListResponse{
		var module = moduleRepository.readByModuleStatus(moduleStatus) 
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleCreatedAt(moduleCreatedAt:String): ModuleReadListResponse{
		var module = moduleRepository.readByModuleCreatedAt(moduleCreatedAt) 
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

	fun readByModuleUpdatedAt(moduleUpdatedAt:String): ModuleReadListResponse{
		var module = moduleRepository.readByModuleUpdatedAt(moduleUpdatedAt) 
		return ModuleReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = module
		)
	}

}
