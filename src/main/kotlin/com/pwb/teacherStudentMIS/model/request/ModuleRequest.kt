//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class ModuleCreateRequest(
   	@get: NotEmpty(message = "moduleName is required")
	var moduleName: String?=null,
	@get: NotEmpty(message = "moduleDescription is required")
	var moduleDescription: String?=null,
	@get: NotEmpty(message = "moduleStatus is required")
	var moduleStatus: String?=null
)

data class ModuleUpdateRequest(
   	@get: NotNull(message = "moduleId is required")
	var moduleId: Int?=null,
	var moduleName: String?=null,
	var moduleDescription: String?=null,
	var moduleStatus: String?=null
)

data class ModuleReadRequest(
   	var moduleId: Int?=null,
	var moduleName: String?=null,
	var moduleDescription: String?=null,
	var moduleStatus: String?=null,
	var moduleCreatedAt: String?=null,
	var moduleUpdatedAt: String?=null
)

data class ModuleDeleteRequest(
   	@get: NotNull(message = "moduleId is required")
	var moduleId: Int?=null
)
