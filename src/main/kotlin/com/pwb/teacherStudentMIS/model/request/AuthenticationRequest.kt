//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.970990200
package com.pwb.teacherStudentMIS.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class InitiateEnrollmentRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null,
	@get: NotEmpty(message = "teacherName is required")
	var teacherName: String?=null,
	@get: NotEmpty(message = "teacherPassword is required")
	var teacherPassword: String?=null
)

data class CompleteEnrollmentRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null,
	@get: NotEmpty(message = "otp is required")
	var  otp: String?=null
)

data class LoginRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null,
	@get: NotEmpty(message = "teacherPassword is required")
	var  teacherPassword: String?=null,
	var deviceId: String?=null,
	var longitude: String?=null,
	var latitude: String?=null
)

data class InitiatePasswordResetRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null
)

data class CompletePasswordResetRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null,
	@get: NotEmpty(message = "otp is required")
	var  otp: String?=null,
	@get: NotEmpty(message = "teacherPassword is required")
	var  teacherPassword: String?=null
)

data class ResendOtpRequest(
   	@get: NotEmpty(message = "teacherEmail is required")
	var teacherEmail: String?=null
)

data class ChangePasswordRequest(
   	@get: NotNull(message = "teacherId is required")
	var teacherPassword: String?=null,
	@get: NotEmpty(message = "oldPassword is required")
	var  oldPassword: String?=null,
	@get: NotEmpty(message = "teacherEmail is required")
	var  username: String?=null
)
