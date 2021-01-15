package com.application.coronaliveserver.domain.cityinfo

data class BigCityInformationResponse(
        val cityName: String,
        val TotalInfected: Int,
        val TotalInfectedInc: Int,
        val LiveInfected: Int,
        val LiveInfectedInc: Int,
        val smallCity: List<String>
)

fun BigCity.toBigCityInformationResponse() = name.let{
    val relatedSmallCity = RelatedSmallCity()
    BigCityInformationResponse(
            it,
            TotalInfected,
            TotalInfectedInc,
            LiveInfected,
            LiveInfectedInc,
            relatedSmallCity.getRelatedSmallCities(name)
    )
}