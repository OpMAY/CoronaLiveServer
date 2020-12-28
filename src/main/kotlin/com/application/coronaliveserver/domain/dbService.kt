package com.application.coronaliveserver.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class dbService @Autowired constructor(private val dbDataTableRepository: dbDataTableRepository){

}