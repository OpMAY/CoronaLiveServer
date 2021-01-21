package com.application.coronaliveserver.domain.cityinfo

data class CityInformationResponse(
        val id : Long,
        val cityName: String,
        val TotalInfected: Int,
        val TotalInfectedInc: Int,
        val LiveInfected: Int,
        val LiveInfectedInc: Int,
        val relatedSmallCity: List<String>?, // 하위도시
        val relatedBigCity : String? // 상위도시
)

fun BigCity.toBigCityInformationResponse() = id?.let{
    val relatedSmallCity = RelatedSmallCity().getRelatedSmallCities(it)
    CityInformationResponse(
            it,
            CityName,
            TotalInfected,
            TotalInfectedInc,
            LiveInfected,
            LiveInfectedInc,
            relatedSmallCity,
            null
    )
}

fun SmallCity.toSmallCityInformationResponse() = id?.let{
    CityInformationResponse(
            it,
            CityName,
            TotalInfected,
            TotalInfectedInc,
            LiveInfected,
            LiveInfectedInc,
            null,
            RelatedBigCity
    )
}