//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.830377400
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class PrivilegeCreateRequest(
   	@get: NotEmpty(message = "privilegeCode is required")
	var privilegeCode: String?=null,
	@get: NotEmpty(message = "privilegeName is required")
	var privilegeName: String?=null,
	@get: NotEmpty(message = "privilegeModuleName is required")
	var privilegeModuleName: String?=null,
	@get: NotEmpty(message = "privilegeDescription is required")
	var privilegeDescription: String?=null,
	@get: NotEmpty(message = "privilegeStatus is required")
	var privilegeStatus: String?=null
)

data class PrivilegeUpdateRequest(
   	@get: NotNull(message = "privilegeId is required")
	var privilegeId: Int?=null,
	var privilegeCode: String?=null,
	var privilegeName: String?=null,
	var privilegeModuleName: String?=null,
	var privilegeDescription: String?=null,
	var privilegeStatus: String?=null
)

data class PrivilegeReadRequest(
   	var privilegeId: Int?=null,
	var privilegeCode: String?=null,
	var privilegeName: String?=null,
	var privilegeModuleName: String?=null,
	var privilegeDescription: String?=null,
	var privilegeStatus: String?=null,
	var privilegeCreatedAt: String?=null,
	var privilegeUpdatedAt: String?=null
)

data class PrivilegeDeleteRequest(
   	@get: NotNull(message = "privilegeId is required")
	var privilegeId: Int?=null
)
