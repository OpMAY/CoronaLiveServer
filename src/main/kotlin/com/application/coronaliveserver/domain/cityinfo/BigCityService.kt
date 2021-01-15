package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired

class BigCityService @Autowired constructor(
        private val bigCityRepository: BigCityRepository,
        private val relatedSmallCity: RelatedSmallCity
){
    fun getSmallCities(bigCity : String){
        relatedSmallCity.getRelatedSmallCities(bigCity)
    }
}