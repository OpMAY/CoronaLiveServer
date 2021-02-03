package com.application.coronaliveserver.controller

import com.application.coronaliveserver.domain.cityinfo.CityRepositorySet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class DbDataApiController @Autowired constructor(
        private val cityRepositorySet: CityRepositorySet
){
    @GetMapping("/update_data")
    fun update() = cityRepositorySet.update()
}