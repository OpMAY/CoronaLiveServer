package com.application.coronaliveserver.domain.smalldata

import com.application.coronaliveserver.domain.tool.Crolling
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SEDService @Autowired constructor(
    private val smallEssentialDataRepository: SmallEssentialDataRepository
) {
    private final val c = Crolling()
    val pNum = c.pNum
    fun savePageNum(){
        smallEssentialDataRepository.save(SmallEssentialData(pNum))
    }
}