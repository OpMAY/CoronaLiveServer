package com.application.coronaliveserver

import com.application.coronaliveserver.tool.AnalyzeMethod
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class Crolling(

) {

    private val analyzeMethod: AnalyzeMethod = AnalyzeMethod()
    fun navigate() {
        setProperty() // Set driver System path property
        val driver: WebDriver = ChromeDriver()
        val js = driver as JavascriptExecutor // Execute JavaScript from driver
        val startPage = 1 // Start Page
        val count = 10 // 가져올 글 갯수

        //URL OPEN
        driver.get(URL)

        //PAGE SET
        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
        driver.findElement(By.cssSelector("a.go_btn")).click()
        Thread.sleep(500) // 0.5s delay

        //글의 번호 가져오기
        val pNum = driver.findElement(By.id("bbs_tr_0_num_td"))
        println("${pNum.text}")

        //CLICK POST
        Thread.sleep(500) // 0.5s delay
        driver.findElements(By.id("bbs_tr_0_bbs_title"))[0].click()
        val errorCount = 0
        for (i in 1..count) {
            //Find Article
            val rePlys = driver.findElement(By.cssSelector("div.boardView")) // 글 content의 위치
            val tList = rePlys.findElements(By.id("sj"))
            val title = tList[0].text
            val text = rePlys.findElements(By.id("cn"))[0].text
            analyseContext(title, text)


            //Next Article
            val ulBoard = driver.findElement(By.cssSelector("ul.boardView_listWrap"))
            ulBoard.findElements(By.id("bbs_gubun"))[0].click()
        }


    }

    private fun setProperty() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe")
        //WebDriver 프로퍼티 설정
    }

    fun analyseContext(title: String, text: String) {
        println("제목 : $title")
        analyzeMethod.analyzeByKeyWord(title, text)
    }

    companion object {
        const val URL = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
    }
}