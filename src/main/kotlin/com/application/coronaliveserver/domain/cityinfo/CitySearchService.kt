package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CitySearchService @Autowired constructor(
        private val cityRepository: CityRepository
) {
    fun searchCity(
            request: CityInformationRequest
    ): List<City>? {
        return cityRepository.findByBigCityNameAndSmallCityName(request.bigCityName, request.smallCityName)
    }

    fun showAllCities() : List<City>{
        return cityRepository.findAll()
    }

    fun showBigCities() : List<City>?{
        return cityRepository.findBySmallCityName(null)
    }
}