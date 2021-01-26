package com.application.coronaliveserver.domain.cityinfo

data class CityInformationResponse(
        val smallCityName: String?,
        val bigCityName: String,
        val TotalInfected: Int,
        val TotalInfectedInc: Int,
        val LiveInfected: Int,
        val LiveInfectedInc: Int,
)

fun City.toCityInformationResponse() = id?.let{
    CityInformationResponse(
            smallCityName,
            bigCityName,
            TotalInfected,
            TotalInfectedInc,
            LiveInfected,
            LiveInfectedInc
    )
}