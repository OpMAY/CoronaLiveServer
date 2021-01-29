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
        return when(request.smallCityName!=null) {
            true -> cityRepository.findBySmallCityName(request.smallCityName)
            else -> cityRepository.findByBigCityName(request.bigCityName)
        }
    }
}