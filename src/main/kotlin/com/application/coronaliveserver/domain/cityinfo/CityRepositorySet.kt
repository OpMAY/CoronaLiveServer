package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityRepositorySet @Autowired constructor(
        private val bigCityRepository: BigCityRepository,
        private val smallCityRepository: SmallCityRepository,

) {
    private lateinit var relatedSmallCity: RelatedSmallCity
    private val bigCity = BigCity(cityName = RelatedSmallCity.BUSAN,0,0,0,0)
    fun register() {
        bigCity.toBigCity(RelatedSmallCity.SEOUL).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.DAEJEON).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.INCHEON).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.DAEGU).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.ULSAN).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.BUSAN).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.GWANGJU).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.SEJONG).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.GYEONGI).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.CHUNGCHEONGSOUTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.CHUNGCHEONGNORTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.GYUNGSANGSOUTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.GYUNGSANGNORTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.JEONLASOUTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.JEONLANORTH).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.GANGWON).run(::saveBigCity)
        bigCity.toBigCity(RelatedSmallCity.JEJU).run(::saveBigCity)
    }

    private fun saveBigCity(BigCity: BigCity) = bigCityRepository.save(BigCity)

    fun saveSmallCity(smallCity: SmallCity) = smallCityRepository.save(smallCity)

    fun getSmallCities(bigCity: String): List<String> = relatedSmallCity.getRelatedSmallCities(bigCity)

}

private fun BigCity.toBigCity(cityName: String) = BigCity(
        cityName,
        TotalInfected,
        TotalInfectedInc,
        LiveInfected,
        LiveInfectedInc
)