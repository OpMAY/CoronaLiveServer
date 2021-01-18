package com.application.coronaliveserver.domain.cityinfo

data class BigCityInformationResponse(
        val id : Long,
        val cityName: String,
        val TotalInfected: Int,
        val TotalInfectedInc: Int,
        val LiveInfected: Int,
        val LiveInfectedInc: Int,
        val smallCity: List<String>
)

fun BigCity.toBigCityInformationResponse() = id?.let{
    val relatedSmallCity = RelatedSmallCity()
    BigCityInformationResponse(
            it,
            name,
            TotalInfected,
            TotalInfectedInc,
            LiveInfected,
            LiveInfectedInc,
            relatedSmallCity.getRelatedSmallCities(it)
    )
}