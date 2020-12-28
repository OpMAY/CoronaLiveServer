package com.application.coronaliveserver.domain

import com.application.coronaliveserver.jpa.BaseEntity
import javax.persistence.*

@Entity
class dbDataTable(
        val dataNum : Int // 이후 뭐가 들어가는지 생각해봐야함
) : BaseEntity() {
}