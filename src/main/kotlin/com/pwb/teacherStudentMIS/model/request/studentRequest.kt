//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class StudentCreateRequest(
   	@get: NotEmpty(message = "studentName is required")
	var studentName: String?=null,
	@get: NotEmpty(message = "studentGrade is required")
	var studentGrade: String?=null
)

data class StudentUpdateRequest(
   	@get: NotNull(message = "studentId is required")
	var studentId: Int?=null,
	var studentName: String?=null,
	var studentGrade: String?=null,
	var studentStatus: String?=null
)

data class StudentReadRequest(
   	var studentId: Int?=null,
	var studentName: String?=null,
	var studentGrade: String?=null,
	var studentStatus: String?=null,
	var studentCreatedAt: String?=null,
	var studentUpdatedAt: String?=null
)

data class StudentDeleteRequest(
   	@get: NotNull(message = "studentId is required")
	var studentId: Int?=null
)
