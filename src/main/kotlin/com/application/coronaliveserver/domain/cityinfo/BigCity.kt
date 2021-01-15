package com.application.coronaliveserver.domain.cityinfo

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.Entity

@Entity(name = "bigcity")
class BigCity(
        var name : String,
        var TotalInfected : Int,
        var TotalInfectedInc : Int,
        var LiveInfected : Int,
        var LiveInfectedInc : Int,
        var smallCity : List<RelatedSmallCity>
) : BaseEntity() {
}