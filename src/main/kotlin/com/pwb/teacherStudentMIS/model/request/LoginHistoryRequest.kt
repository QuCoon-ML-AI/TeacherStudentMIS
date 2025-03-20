//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.814741700
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class LoginHistoryCreateRequest(
   	@get: NotEmpty(message = "loginHistoryUsername is required")
	var loginHistoryUsername: String?=null,
	@get: NotEmpty(message = "loginHistoryIpAddress is required")
	var loginHistoryIpAddress: String?=null,
	@get: NotEmpty(message = "loginHistoryDeviceId is required")
	var loginHistoryDeviceId: String?=null,
	@get: NotEmpty(message = "loginHistoryLongitude is required")
	var loginHistoryLongitude: String?=null,
	@get: NotEmpty(message = "loginHistoryLatitude is required")
	var loginHistoryLatitude: String?=null,
	@get: NotEmpty(message = "loginHistoryStatus is required")
	var loginHistoryStatus: String?=null
)

data class LoginHistoryUpdateRequest(
   	@get: NotNull(message = "loginHistoryId is required")
	var loginHistoryId: Int?=null,
	var loginHistoryUsername: String?=null,
	var loginHistoryIpAddress: String?=null,
	var loginHistoryDeviceId: String?=null,
	var loginHistoryLongitude: String?=null,
	var loginHistoryLatitude: String?=null,
	var loginHistoryStatus: String?=null
)

data class LoginHistoryReadRequest(
   	var loginHistoryId: Int?=null,
	var loginHistoryUsername: String?=null,
	var loginHistoryIpAddress: String?=null,
	var loginHistoryDeviceId: String?=null,
	var loginHistoryLongitude: String?=null,
	var loginHistoryLatitude: String?=null,
	var loginHistoryStatus: String?=null,
	var loginHistoryCreatedAt: String?=null,
	var loginHistoryUpdatedAt: String?=null
)

data class LoginHistoryDeleteRequest(
   	@get: NotNull(message = "loginHistoryId is required")
	var loginHistoryId: Int?=null
)
