package com.application.coronaliveserver.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface dbDataTableRepository : JpaRepository<dbDataTable,Long> {
}