package com.application.coronaliveserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoronaLiveServerApplication

fun main(args: Array<String>) {
	runApplication<CoronaLiveServerApplication>(*args)
}
