package com.application.coronaliveserver.domain.cityinfo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityRepositorySet @Autowired constructor(
        private val cityRepository: CityRepository
        ) {
    private var relatedSmallCity = RelatedSmallCity()
    private val city = City(
            "",
            "",
            0,
            0,
            0,
            0
    )
    fun register() {
        dbSetting(RelatedSmallCity.DAEJEON)
        dbSetting(RelatedSmallCity.INCHEON)
        dbSetting(RelatedSmallCity.DAEGU)
        dbSetting(RelatedSmallCity.ULSAN)
        dbSetting(RelatedSmallCity.BUSAN)
        dbSetting(RelatedSmallCity.GWANGJU)
        dbSetting(RelatedSmallCity.SEJONG)
        dbSetting(RelatedSmallCity.GYEONGI)
        dbSetting(RelatedSmallCity.CHUNGCHEONGSOUTH)
        dbSetting(RelatedSmallCity.CHUNGCHEONGNORTH)
        dbSetting(RelatedSmallCity.GYUNGSANGSOUTH)
        dbSetting(RelatedSmallCity.GYUNGSANGNORTH)
        dbSetting(RelatedSmallCity.JEONLASOUTH)
        dbSetting(RelatedSmallCity.JEONLANORTH)
        dbSetting(RelatedSmallCity.GANGWON)
        dbSetting(RelatedSmallCity.JEJU)
    }
    fun update(){

    }
    private fun dbSetting(mainCity : String){
        city.toCity(null,mainCity).run(::saveBigCity)
        for(element in getSmallCities(mainCity)) {
            city.toCity(element, mainCity).run(::saveBigCity)
        }
    }
    private fun saveBigCity(City: City) = cityRepository.save(City)

    fun getSmallCities(bigCity: String): List<String> = relatedSmallCity.getRelatedSmallCities(bigCity)

}

private fun City.toCity(SmallCityName: String?, BigCityName: String) = City(
        SmallCityName,
        BigCityName,
        TotalInfected,
        TotalInfectedInc,
        LiveInfected,
        LiveInfectedInc
)