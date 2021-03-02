package com.application.coronaliveserver.domain.smalldata

import com.application.coronaliveserver.domain.jpa.BaseEntity
import javax.persistence.Entity

@Entity
class SmallEssentialData(
    val pageNum : Int
) : BaseEntity() {
}