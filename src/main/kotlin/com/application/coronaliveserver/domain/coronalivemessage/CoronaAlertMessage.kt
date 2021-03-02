package com.application.coronaliveserver.domain.coronalivemessage

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.*

@Entity
class CoronaAlertMessage(
        val alertNum : Int,
        val message : String,
        val sentFrom : String,
        val numberFromMessage : Int
) : BaseEntity() {
}