//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.970990200
package com.pwb.teacherStudentMIS.model.response


data class LoginResponse(
   	var teacherId: Int?=null,
	var teacherEmail: String?=null,
	var teacherName: String?=null,
	var teacherStatus: String?=null,
	var teacherCreatedAt: String?=null,
	var teacherUpdatedAt: String?=null,
	var privileges: List<String> = mutableListOf(),
	var token: String?=null,
	var responseCode: String?=null,
	var responseMessage: String?=null
)
