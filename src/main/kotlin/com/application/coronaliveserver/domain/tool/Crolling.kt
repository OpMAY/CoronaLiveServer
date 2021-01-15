package com.application.coronaliveserver.domain.tool

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit


class Crolling(

) {
    private lateinit var mtitle: String
    private lateinit var mtext: String
    fun navigate() {
        setProperty() // Set driver System path property

        // Set selenium chrome options
        val options = ChromeOptions()
        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
        options.addArguments("lang=ko_KR")
        options.addArguments("--window-size=1920,1080")
        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        val driver: WebDriver = ChromeDriver(options)

        val js = driver as JavascriptExecutor // Execute JavaScript from driver
        val startPage = 1 // Start Page
        val count = 10 // 가져올 글 갯수

        //URL OPEN
        driver.get(URL)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay

        //PAGE SET
        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
        driver.findElement(By.cssSelector("a.go_btn")).sendKeys(Keys.ENTER)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay

        //글의 번호 가져오기
        val pNum = driver.findElement(By.id("bbs_tr_0_num_td"))
        println(pNum.text)

        //CLICK POST
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay
        driver.findElements(By.id("bbs_tr_0_bbs_title"))[0].sendKeys(Keys.ENTER)
        val errorCount = 0
        var InfectedMessage: Int = 0
        for (i in 1..count) {
            //Find Article
            val rePlys = driver.findElement(By.cssSelector("div.boardView")) // 글 content의 위치
            val tList = rePlys.findElements(By.id("sj"))
            mtitle = tList[0].text
            mtext = rePlys.findElements(By.id("cn"))[0].text
            val analyzeMethod = AnalyzeMethod(mtext)
            analyzeMethod.analyze()
            if (analyzeMethod.isKeywordCorrect)
                InfectedMessage++

            println("확진자 문자 갯수 : $InfectedMessage")
            //Next Article
            val ulBoard = driver.findElement(By.cssSelector("ul.boardView_listWrap"))
            ulBoard.findElements(By.id("bbs_gubun"))[0].click()
        }


    }

    private fun setProperty() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe")
        //WebDriver 프로퍼티 설정
    }

    companion object {
        const val URL = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
    }
}