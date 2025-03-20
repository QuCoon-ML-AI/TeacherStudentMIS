//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.config

import org.pwb.utility.constant.GSON
import org.pwb.utility.exception.BadRequestException
import org.pwb.utility.exception.exceptionWrapper
import org.pwb.utility.model.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
@RestController
class GlobalExceptionConfig {
    @ExceptionHandler(Exception::class)
    fun handleGlobalException(ex: Exception, request: WebRequest?): ResponseEntity<Any> {
        ex.printStackTrace()
        return ResponseEntity(GSON.fromJson(exceptionWrapper { throw ex }, BaseResponse::class.java), HttpStatus.OK)
    }
    @ExceptionHandler(RuntimeException::class)
    fun handleGlobalRuntimeException(ex: Exception, request: WebRequest?): ResponseEntity<Any> {
        ex.printStackTrace()
        return ResponseEntity(GSON.fromJson(exceptionWrapper { throw ex }, BaseResponse::class.java), HttpStatus.OK)
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidExceptionException(ex: MethodArgumentNotValidException, request: WebRequest?): ResponseEntity<Any> {
        ex.printStackTrace()
        return ResponseEntity(GSON.fromJson(exceptionWrapper {
            throw BadRequestException(ex.allErrors.map { e -> e.defaultMessage }.joinToString(",")) },
            BaseResponse::class.java), HttpStatus.OK)
    }
}

