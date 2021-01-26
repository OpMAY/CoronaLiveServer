package com.application.coronaliveserver.domain.cityinfo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BigCityRepository : JpaRepository<BigCity, Long>{

    fun findByCityName(name : String): BigCity?
}