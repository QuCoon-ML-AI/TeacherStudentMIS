//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class AuditLog(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var auditLogId: Int?=null,
	@Column(type="INT", length=100)
	var auditLogUserId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var auditLogAction: String?=null,
	@Column(type="VARCHAR(n)", length=2000)
	var auditLogRequest: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=2000)
	var auditLogResponse: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var auditLogModule: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=10)
	var auditLogResponseCode: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=10)
	var auditLogResponseMessage: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var auditLogStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var auditLogCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var auditLogUpdatedAt: String?=null
)
