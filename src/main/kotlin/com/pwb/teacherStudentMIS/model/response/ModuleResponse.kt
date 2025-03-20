//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.model.response

import com.pwb.teacherStudentMIS.model.entity.Module


data class ModuleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Module>
)

data class ModuleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Module
)
