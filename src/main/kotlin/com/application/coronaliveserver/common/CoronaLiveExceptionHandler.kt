package com.application.coronaliveserver.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class CoronaLiveExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(CoronaLiveException::class)
    fun handleCoronaLiveException(e: CoronaLiveException): ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ApiResponse{
        logger.error("API error", e)
        return ApiResponse.error("알 수 없는 오류")
    }
}

//전역 익셉션 핸들러, 만약 coronaliveexception을 우리가 설정해놓은 내용이 있으면 그 에러메세지 갖고와서 출력
//그게 아니면 밑에걸로 뜸