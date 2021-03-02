package com.application.coronaliveserver.controller

import com.application.coronaliveserver.domain.cityinfo.CityRepositorySet
import com.application.coronaliveserver.domain.smalldata.SEDService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class DbDataApiController @Autowired constructor(
        private val cityRepositorySet: CityRepositorySet,
        private val sedService: SEDService
){
    @GetMapping("/update_data")
    fun update() = cityRepositorySet.dailyUpdate()

    @GetMapping("/db_update")
    fun dbUpdate() = cityRepositorySet.dbSetting()

    @GetMapping("/set_page_um")
    fun setPageNum() = sedService.savePageNum()
}