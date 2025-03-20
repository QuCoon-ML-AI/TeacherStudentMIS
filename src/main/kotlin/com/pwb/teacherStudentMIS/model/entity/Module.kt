//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.892856200
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class Module(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var moduleId: Int?=null,
	@Column(type="VARCHAR(n)", length=100)
	var moduleName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var moduleDescription: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var moduleStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var moduleCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var moduleUpdatedAt: String?=null
)
