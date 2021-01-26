package com.application.coronaliveserver.domain.cityinfo

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.Entity

@Entity(name = "city")
class City(
        var smallCityName : String?,
        var bigCityName : String,
        var TotalInfected : Int,
        var TotalInfectedInc : Int,
        var LiveInfected : Int,
        var LiveInfectedInc : Int
) : BaseEntity() {
}