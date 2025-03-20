//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.767874100
package com.pwb.teacherStudentMIS.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class class(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var classId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var className: String?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="TEACHER(teacherId)")
	var classTeacherId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var classStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var classCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var classUpdatedAt: String?=null
)
