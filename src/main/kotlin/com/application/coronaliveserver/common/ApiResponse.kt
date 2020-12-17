package com.application.coronaliveserver.common

data class ApiResponse (
        val success: Boolean,
        val data: Any? = null,
        val message: String? = null
){
    companion object {
        fun ok(data: Any? = null) = ApiResponse(true,data)
        fun error(message: String? = null) = ApiResponse(false, message = message)
    }
}

//api 스펙 통일 부분(parayo와 동일하게 구성했음)
//성공여부, 데이터, 메시지
//fun ok와 error를 이용해서 Apiresponse.ok(data) 형태 써보면 api응답 체크 가능