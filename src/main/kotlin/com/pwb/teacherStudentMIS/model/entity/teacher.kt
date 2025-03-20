//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.627320400
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class teacher(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var teacherId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var teacherEmail: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var teacherName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var teacherStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var teacherCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var teacherUpdatedAt: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var teacherPassword: String?=null
)
