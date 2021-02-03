package com.application.coronaliveserver

import com.application.coronaliveserver.domain.tool.Crolling
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlinx.coroutines.*

@SpringBootApplication
class CoronaLiveServerApplication

fun main() {
	//서버 구동
	runApplication<CoronaLiveServerApplication>()

	//크롤링 시행

	//c.navigate()
	//c.navigateDailyLocalCoronaInfectedInfo()
	//c.navigateLocalAlertPhaseInfo()
	//TODO:크롤링 주기 설정

	val calendar = Calendar.getInstance()
	calendar.timeInMillis = System.currentTimeMillis()
	calendar.set(Calendar.HOUR_OF_DAY, 0)
	calendar.set(Calendar.MINUTE, 0)
	calendar.set(Calendar.SECOND, 0)
	val timer = Timer()
	//timer.schedule(autoUpdate(), calendar.time, TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS))


}

fun autoUpdate(){
	val c = Crolling()
	c.autoUpdate()
}
