package com.application.coronaliveserver.domain.cityinfo

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.Entity

@Entity(name = "smallcity")
class SmallCity(
        var CityName : String,
        var RelatedBigCity : String,
        var TotalInfected : Int,
        var TotalInfectedInc : Int,
        var LiveInfected : Int,
        var LiveInfectedInc : Int
) : BaseEntity() {
}