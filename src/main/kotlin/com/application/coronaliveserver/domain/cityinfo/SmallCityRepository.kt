package com.application.coronaliveserver.domain.cityinfo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SmallCityRepository : JpaRepository<SmallCity, Long> {
    fun findByCityName(smallCity : String) : SmallCity?
}