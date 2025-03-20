//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.teacher


data class TeacherReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<teacher>
)

data class TeacherReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: teacher
)
