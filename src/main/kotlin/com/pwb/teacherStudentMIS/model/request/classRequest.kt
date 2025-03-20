//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.783477800
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class ClassCreateRequest(
   	@get: NotEmpty(message = "className is required")
	var className: String?=null,
	@get: NotNull(message = "classTeacherId is required")
	var classTeacherId: Int?=null
)

data class ClassUpdateRequest(
   	@get: NotNull(message = "classId is required")
	var classId: Int?=null,
	var className: String?=null,
	var classTeacherId: Int?=null,
	var classStatus: String?=null
)

data class ClassReadRequest(
   	var classId: Int?=null,
	var className: String?=null,
	var classTeacherId: Int?=null,
	var classStatus: String?=null,
	var classCreatedAt: String?=null,
	var classUpdatedAt: String?=null
)

data class ClassDeleteRequest(
   	@get: NotNull(message = "classId is required")
	var classId: Int?=null
)
