package com.application.coronaliveserver.domain.dummy

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface dbDataTableRepository : JpaRepository<dbDataTable,Long> {
}