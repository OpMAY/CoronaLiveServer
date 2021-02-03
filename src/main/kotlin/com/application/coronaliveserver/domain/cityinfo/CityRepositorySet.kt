package com.application.coronaliveserver.domain.cityinfo

import com.application.coronaliveserver.domain.tool.Crolling
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityRepositorySet @Autowired constructor(
        private val cityRepository: CityRepository
        ) {
    // 확진자 증가 수
    private var increasedNum = 0
    private var relatedSmallCity = RelatedSmallCity()
    val list = mapOf(
            "서울" to "서울특별시", "경기" to "경기도", "인천" to "인천광역시",
            "강원" to "강원도", "세종" to "세종시", "대전" to "대전광역시",
            "충북" to "충청북도", "충남" to "충청남도", "경북" to "경상북도",
            "경남" to "경상남도", "대구" to "대구광역시", "전북" to "전라북도",
            "전남" to "전라남도", "광주" to "광주광역시", "부산" to "부산광역시",
            "울산" to "울산광역시", "제주" to "제주도", "검역" to "검역"
    )
    private val city = City(
            "",
            "",
            0,
            0,
            0,
            0
    )
    val crolling = Crolling()

    fun update(){
        crolling.navigateDailyLocalCoronaInfectedInfo()
        for(key in list.keys) {
            println(crolling.dailyTotalInfectedKorea[key])
            val number = crolling.dailyTotalInfectedKorea[key] ?: error("지역 확진자 숫자 오류")
            val localFullName = list[key] ?: error("지역 이름 오류")
            cityRepository.findByBigCityName(localFullName)?.let {
                for (element in it) {
                    if (element.smallCityName == null || element.smallCityName == localFullName) {
                        element.LiveInfected = element.LiveInfected.plus(number)
                        element.LiveInfectedInc = increasedNum
                        element.TotalInfected = element.TotalInfected.plus(number)
                        element.TotalInfectedInc = increasedNum
                        cityRepository.save(element)
                    }
                }
            }
        }

    }
    private fun dbSetting(mainCity : String){
        city.toCity(null,mainCity).run(::saveBigCity)
        for(element in getSmallCities(mainCity)) {
            city.toCity(element, mainCity).run(::saveBigCity)
        }
    }
    private fun saveBigCity(City: City) = cityRepository.save(City)

    fun getSmallCities(bigCity: String): List<String> = relatedSmallCity.getRelatedSmallCities(bigCity)

    //TODO : 크롤링으로 받아온 지역 감염 정보 구분하여 확진자수 누적 추가
}

private fun City.toCity(SmallCityName: String?, BigCityName: String) = City(
        SmallCityName,
        BigCityName,
        TotalInfected,
        TotalInfectedInc,
        LiveInfected,
        LiveInfectedInc
)

private fun City.toCityUpdate() = City(
        smallCityName, bigCityName, TotalInfected, TotalInfectedInc, LiveInfected, LiveInfectedInc
)