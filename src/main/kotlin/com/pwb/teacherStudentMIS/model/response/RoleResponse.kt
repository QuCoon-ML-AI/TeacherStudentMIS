//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.861600400
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.Role


data class RoleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Role>
)

data class RoleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Role
)
