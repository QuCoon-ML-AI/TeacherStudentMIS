//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.814741700
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class LoginHistory(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var loginHistoryId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var loginHistoryUsername: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var loginHistoryIpAddress: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,foreignKey=true,length=100)
	var loginHistoryDeviceId: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var loginHistoryLongitude: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var loginHistoryLatitude: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var loginHistoryStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var loginHistoryCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var loginHistoryUpdatedAt: String?=null
)
