//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class AuditLogCreateRequest(
   	@get: NotNull(message = "auditLogUserId is required")
	var auditLogUserId: Int?=null,
	@get: NotEmpty(message = "auditLogAction is required")
	var auditLogAction: String?=null,
	@get: NotEmpty(message = "auditLogRequest is required")
	var auditLogRequest: String?=null,
	@get: NotEmpty(message = "auditLogResponse is required")
	var auditLogResponse: String?=null,
	@get: NotEmpty(message = "auditLogModule is required")
	var auditLogModule: String?=null,
	@get: NotEmpty(message = "auditLogResponseCode is required")
	var auditLogResponseCode: String?=null,
	@get: NotEmpty(message = "auditLogResponseMessage is required")
	var auditLogResponseMessage: String?=null,
	@get: NotEmpty(message = "auditLogStatus is required")
	var auditLogStatus: String?=null
)

data class AuditLogUpdateRequest(
   	@get: NotNull(message = "auditLogId is required")
	var auditLogId: Int?=null,
	var auditLogAction: String?=null,
	var auditLogRequest: String?=null,
	var auditLogResponse: String?=null,
	var auditLogModule: String?=null,
	var auditLogResponseCode: String?=null,
	var auditLogResponseMessage: String?=null,
	var auditLogStatus: String?=null
)

data class AuditLogReadRequest(
   	var auditLogId: Int?=null,
	var auditLogUserId: Int?=null,
	var auditLogAction: String?=null,
	var auditLogRequest: String?=null,
	var auditLogResponse: String?=null,
	var auditLogModule: String?=null,
	var auditLogResponseCode: String?=null,
	var auditLogResponseMessage: String?=null,
	var auditLogStatus: String?=null,
	var auditLogCreatedAt: String?=null,
	var auditLogUpdatedAt: String?=null
)

data class AuditLogDeleteRequest(
   	@get: NotNull(message = "auditLogId is required")
	var auditLogId: Int?=null
)
