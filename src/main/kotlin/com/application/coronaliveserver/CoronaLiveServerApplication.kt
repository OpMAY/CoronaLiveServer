package com.application.coronaliveserver

import com.application.coronaliveserver.domain.tool.Crolling
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoronaLiveServerApplication

fun main() {
	//서버 구동
	runApplication<CoronaLiveServerApplication>()

	//크롤링 시행
	val c = Crolling()
	//c.navigate()
	//c.navigateDailyLocalCoronaInfectedInfo()
	//c.navigateLocalAlertPhaseInfo()
	//TODO:크롤링 주기 설정

}
