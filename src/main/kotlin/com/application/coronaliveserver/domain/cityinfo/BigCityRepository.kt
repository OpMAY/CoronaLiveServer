package com.application.coronaliveserver.domain.cityinfo

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BigCityRepository : JpaRepository<BigCity, Long>{
    fun findByCityNameLessThanOrderByIdDesc(
            cityName : String, pageable :Pageable
    ) : List<BigCity>

    fun findByCityNameGreaterThanOrderByIdDesc(
            cityName: String, pageable: Pageable
    ) : List<BigCity>
}