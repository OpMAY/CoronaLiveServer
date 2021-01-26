package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CitySearchService @Autowired constructor(
        private val bigCityRepository: BigCityRepository,
        private val smallCityRepository: SmallCityRepository
) {
    fun search(
            bigCity: String,
            smallCity: String?
    ) {
        searchBigCity(bigCity)
        smallCity?.let {
            searchSmallCity(it)
        }
    }


    private fun searchBigCity(
            cityName: String
    ): BigCity? {
        return bigCityRepository.findByCityName(cityName)
    }

    private fun searchSmallCity(
            cityName: String?
    ): SmallCity? {
        return smallCityRepository.findByCityName(cityName!!)
    }


    fun registerInfo() {
        bigCityRepository.flush()
    }
}