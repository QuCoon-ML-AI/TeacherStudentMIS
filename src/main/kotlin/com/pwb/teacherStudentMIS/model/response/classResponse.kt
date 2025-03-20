//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.783477800
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.class


data class ClassReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<class>
)

data class ClassReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: class
)
