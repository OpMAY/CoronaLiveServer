package com.application.coronaliveserver.domain.cityinfo

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity(name = "bigcity")
class BigCity(
        var name : String,
        var TotalInfected : Int,
        var TotalInfectedInc : Int,
        var LiveInfected : Int,
        var LiveInfectedInc : Int,
        @OneToMany
        @JoinColumn(name = "bigcityId")
        var smallCity : MutableList<SmallCity>
) : BaseEntity() {
}