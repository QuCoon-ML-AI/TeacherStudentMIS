//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.877253
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class RolePrivilege(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var rolePrivilegeId: Int?=null,
	@Column(type="INT", length=100)
	var rolePrivilegeRoleId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var rolePrivilegePrivilegeCode: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var rolePrivilegeStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var rolePrivilegeCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var rolePrivilegeUpdatedAt: String?=null
)
