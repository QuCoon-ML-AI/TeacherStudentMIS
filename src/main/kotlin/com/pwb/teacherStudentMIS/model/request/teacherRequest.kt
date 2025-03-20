//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class TeacherCreateRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null,
	@get: NotEmpty(message = "teacherName is required")
	var teacherName: String?=null,
	@get: NotEmpty(message = "teacherPassword is required")
	var teacherPassword: String?=null
)

data class TeacherUpdateRequest(
   	@get: NotNull(message = "teacherId is required")
	var teacherId: Int?=null,
	var teacherEmail: String?=null,
	var teacherName: String?=null,
	var teacherStatus: String?=null,
	var teacherPassword: String?=null
)

data class TeacherReadRequest(
   	var teacherId: Int?=null,
	var teacherEmail: String?=null,
	var teacherName: String?=null,
	var teacherStatus: String?=null,
	var teacherCreatedAt: String?=null,
	var teacherUpdatedAt: String?=null,
	var teacherPassword: String?=null
)

data class TeacherDeleteRequest(
   	@get: NotNull(message = "teacherId is required")
	var teacherId: Int?=null
)
