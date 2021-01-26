package com.application.coronaliveserver.controller

import com.application.coronaliveserver.common.ApiResponse
import com.application.coronaliveserver.domain.cityinfo.City
import com.application.coronaliveserver.domain.cityinfo.CitySearchService
import com.application.coronaliveserver.domain.cityinfo.toCityInformationResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CityApiController @Autowired constructor(
        private val citySearchService: CitySearchService
){

    @GetMapping("/cities")
    fun search(
            @RequestParam bigCity : String,
            @RequestParam(required = false) smallCity:String?
    ) = citySearchService
            .searchCity(bigCity, smallCity)
            ?.mapNotNull(City::toCityInformationResponse)
            .let { ApiResponse.ok(it) }
}