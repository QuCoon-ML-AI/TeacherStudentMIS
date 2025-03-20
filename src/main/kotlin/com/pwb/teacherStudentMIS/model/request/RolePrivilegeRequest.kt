//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class RolePrivilegeCreateRequest(
   	@get: NotNull(message = "rolePrivilegeRoleId is required")
	var rolePrivilegeRoleId: Int?=null,
	@get: NotEmpty(message = "rolePrivilegePrivilegeCode is required")
	var rolePrivilegePrivilegeCode: String?=null,
	@get: NotEmpty(message = "rolePrivilegeStatus is required")
	var rolePrivilegeStatus: String?=null
)

data class RolePrivilegeUpdateRequest(
   	@get: NotNull(message = "rolePrivilegeId is required")
	var rolePrivilegeId: Int?=null,
	var rolePrivilegeRoleId: Int?=null,
	var rolePrivilegePrivilegeCode: String?=null,
	var rolePrivilegeStatus: String?=null
)

data class RolePrivilegeReadRequest(
   	var rolePrivilegeId: Int?=null,
	var rolePrivilegeRoleId: Int?=null,
	var rolePrivilegePrivilegeCode: String?=null,
	var rolePrivilegeStatus: String?=null,
	var rolePrivilegeCreatedAt: String?=null,
	var rolePrivilegeUpdatedAt: String?=null
)

data class RolePrivilegeDeleteRequest(
   	@get: NotNull(message = "rolePrivilegeId is required")
	var rolePrivilegeId: Int?=null
)
