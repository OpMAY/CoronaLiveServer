package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class BigCityService @Autowired constructor(
        private val bigCityRepository: BigCityRepository,
        private val relatedSmallCity: RelatedSmallCity
){
    fun getSmallCities(bigCity : Long){
        relatedSmallCity.getRelatedSmallCities(bigCity)
    }

    fun get(id: Long) = bigCityRepository.findByIdOrNull(id)

    fun registerInfo(){
    }
}