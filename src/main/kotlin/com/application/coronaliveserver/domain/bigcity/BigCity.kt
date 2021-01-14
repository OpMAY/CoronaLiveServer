package com.application.coronaliveserver.domain.bigcity

import javax.persistence.Entity

@Entity(name = "bigcity")
class BigCity(
        var name : String,
        var TotalInfected : Int,
        var TotalInfectedInc : Int,
        var LiveInfected : Int,
        var LiveInfectedInc : Int
) {
}