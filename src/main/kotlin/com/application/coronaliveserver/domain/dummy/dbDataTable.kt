package com.application.coronaliveserver.domain.dummy

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.*

@Entity
class dbDataTable(
        val dataNum : Int, // 이후 뭐가 들어가는지 생각해봐야함
        val placeFrom : String,
        val peopleCount : Int?,
        val peopleNumber : Int?
) : BaseEntity() {
}