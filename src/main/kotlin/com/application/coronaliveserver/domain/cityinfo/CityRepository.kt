package com.application.coronaliveserver.domain.cityinfo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, Long>{

    fun findByBigCityName(bigCityName : String): List<City>?

    fun findBySmallCityName(smallCityName : String?): List<City>?

    fun findByBigCityNameAndSmallCityName(bigCityName: String, smallCityName: String?) : List<City>?

}