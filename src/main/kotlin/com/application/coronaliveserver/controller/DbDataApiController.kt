package com.application.coronaliveserver.controller

import com.application.coronaliveserver.domain.cityinfo.CityRepositorySet
import com.application.coronaliveserver.domain.dbService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class DbDataApiController @Autowired constructor(
        private val dbService: dbService,
        private val cityRepositorySet: CityRepositorySet
){
    @GetMapping("/db_data")
    fun search(
            @RequestParam locationId : Int,
            @RequestParam(required = false) limit : Int?
    ) = dbService
            .search(locationId,limit ?: 10)

    @GetMapping("/update_data")
    fun update() = cityRepositorySet.update()
}