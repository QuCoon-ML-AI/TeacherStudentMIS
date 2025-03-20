//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.830377400
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.Privilege


data class PrivilegeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Privilege>
)

data class PrivilegeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Privilege
)
