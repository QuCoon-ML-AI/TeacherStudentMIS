//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.705530100
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.student


data class StudentReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<student>
)

data class StudentReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: student
)
