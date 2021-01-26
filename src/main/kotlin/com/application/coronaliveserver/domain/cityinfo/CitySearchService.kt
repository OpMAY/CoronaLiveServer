package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CitySearchService @Autowired constructor(
        private val cityRepository: CityRepository
) {
    fun searchCity(
            BigCityName: String,
            SmallCityName: String?
    ): List<City>? {
        return when(SmallCityName!=null) {
            true -> cityRepository.findBySmallCityName(SmallCityName)
            else -> cityRepository.findByBigCityName(BigCityName)
        }
    }
}