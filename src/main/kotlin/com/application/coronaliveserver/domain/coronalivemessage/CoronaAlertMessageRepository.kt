package com.application.coronaliveserver.domain.coronalivemessage

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoronaAlertMessageRepository : JpaRepository<CoronaAlertMessage,Long> {
}