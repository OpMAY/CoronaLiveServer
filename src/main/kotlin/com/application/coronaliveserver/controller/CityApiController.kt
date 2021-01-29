package com.application.coronaliveserver.controller

import com.application.coronaliveserver.common.ApiResponse
import com.application.coronaliveserver.domain.cityinfo.City
import com.application.coronaliveserver.domain.cityinfo.CityInformationRequest
import com.application.coronaliveserver.domain.cityinfo.CitySearchService
import com.application.coronaliveserver.domain.cityinfo.toCityInformationResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class CityApiController @Autowired constructor(
        private val citySearchService: CitySearchService
){

    @GetMapping("/cities")
    fun search(
            @RequestBody request : CityInformationRequest
    ) = citySearchService
            .searchCity(request)
            ?.mapNotNull(City::toCityInformationResponse)
            .let { ApiResponse.ok(it) }
}