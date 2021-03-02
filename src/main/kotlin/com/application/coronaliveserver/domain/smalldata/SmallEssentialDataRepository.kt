package com.application.coronaliveserver.domain.smalldata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SmallEssentialDataRepository : JpaRepository<SmallEssentialData, Long> {
}