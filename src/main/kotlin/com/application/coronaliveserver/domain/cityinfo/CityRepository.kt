package com.application.coronaliveserver.domain.cityinfo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, Long>{

    fun findByBigCityName(name : String): List<City>?

    fun findBySmallCityName(name : String?):List<City>?
}