package com.application.coronaliveserver

import com.application.coronaliveserver.domain.tool.Crolling
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import java.util.concurrent.TimeUnit

@SpringBootApplication
class CoronaLiveServerApplication

fun main() {
    //서버 구동
    runApplication<CoronaLiveServerApplication>()

    val c = Crolling()
    //c.navigateLocalAlertPhaseInfo()
    /*runBlocking {
        val todayUpdate = launch {
            dailyUpdate(9,0)
        }
        todayUpdate.join()
    }*/
    //크롤링 시행
    //getMessage()
    //TODO 60초 간격으로 재난문자 크롤링 시행할 수 있게 작성은 했음, 재난문자 분류 작업 로직이 필요
    //주기 시행



}

fun autoUpdate() {
    val c = Crolling()
    c.autoUpdate()
    // 매일 갱신되는 총 확진자수, 거리두기 단계 가져오기
}
fun dailyUpdate(hour : Int, minute: Int){
    val dailyInfoUpdateCalendar = Calendar.getInstance()
    dailyInfoUpdateCalendar.timeInMillis = System.currentTimeMillis()
    //매일 주기적으로 업데이트 할 시간 (현재 : hour:minute:00)
    dailyInfoUpdateCalendar.set(Calendar.HOUR_OF_DAY, hour)
    dailyInfoUpdateCalendar.set(Calendar.MINUTE, minute)
    dailyInfoUpdateCalendar.set(Calendar.SECOND, 0)
    val dailyTimer = Timer()
    dailyTimer.schedule(
        object : TimerTask() {
            override fun run() {
                autoUpdate()
            }
        },
        dailyInfoUpdateCalendar.time, TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)
    )
}
fun getMessage(){
    val c = Crolling()
    val timer = Timer()
    timer.schedule(
        object : TimerTask(){
            override fun run() {
                c.navigateLiveMessage()
            }
        }
    , 1000, 60000
    ) // 1초 딜레이를 가지고 60초마다 실행
}
