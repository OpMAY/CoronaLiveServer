package com.application.coronaliveserver.domain.coronalivemessage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CoronaLiveMessageService @Autowired constructor(
        private val CoronaAlertMessageRepository: CoronaAlertMessageRepository
) {
    fun search(
            LocationId : Int?,
            limit : Int
    ):List<CoronaAlertMessage> {
        val pageable = PageRequest.of(0, limit)
        val condition = PlaceSearchCondition(
                LocationId == null,
                0
        )
        return when(condition){
            NO_PLACE_SELECTED -> TODO("메인 화면에 나올 데이터 띄우기")
            PLACE_SELECTED -> TODO("지역에 대한 세부 정보 띄우기")
            else -> throw IllegalStateException("지역 정보 없음")
        }
    }

    data class PlaceSearchCondition(
            val locationIsSelected : Boolean,
            val pageNumber : Int
    )

    companion object{
        val NO_PLACE_SELECTED = PlaceSearchCondition(false,  0)
        val PLACE_SELECTED = PlaceSearchCondition(true, 0)
    }

    fun get(id: Long) = CoronaAlertMessageRepository.findByIdOrNull(id)
}