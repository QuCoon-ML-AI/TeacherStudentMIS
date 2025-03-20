//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T02:40:52.517852900
package com.pwb.teacherStudentMIS.controller

import com.pwb.teacherStudentMIS.utility.Environment
import com.pwb.teacherStudentMIS.utility.constant.PrefixConstant
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.database.GenerateQuery
import org.pwb.utility.model.response.BaseDataResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/{stage}/migration")
class MigrationController(
    private val environment: Environment
) {

    @GetMapping("/execute")
    fun execute(@PathVariable stage: String): BaseDataResponse{
        return BaseDataResponse(
            responseCode = ResponseConstant.SUCCESS.responseCode,
            responseMessage = ResponseConstant.SUCCESS.responseMessage,
            data = GenerateQuery().createEntity(
                "com.pwb.teacherStudentMIS.model.entity",
                PrefixConstant.ENTITY,
                environment.databaseUtil?.sql2oConnection!!,
                environment.executeDatabaseMigration
            )
        )
    }
}
