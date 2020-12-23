package com.application.coronaliveserver

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class Crolling {

    fun navigate() {
        setProperty() // Set driver System path property
        val driver: WebDriver = ChromeDriver()
        val js = driver as JavascriptExecutor // Execute JavaScript from driver
        val startPage = 2 // Start Page
        val count = 10 // 가져올 글 갯수

        //URL OPEN
        driver.get(URL)

        //PAGE SET
        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
        driver.findElement(By.cssSelector("a.go_btn")).click()
        driver.findElement(By.tagName("button")).click()

        //글의 번호 가져오기
        val pNum = driver.findElement(By.id("bbs_tr_0_num_td"))
        println("${pNum.text}")

        //CLICK POST
        driver.findElements(By.id("bbs_tr_0_bbs_title"))[0].click()
        val errorCount = 0
        for (i in 1..count) {
            //Find Article
            val rePlys = driver.findElement(By.cssSelector("div.boardView")) // 글 content의 위치
            val tList = rePlys.findElements(By.id("sj"))
            val title = tList[0].text
            val text = rePlys.findElements(By.id("cn"))[0].text
            println("$i \n제목 : $title")
            println("내용 : $text\n")

            //Next Article
            val ulBoard = driver.findElement(By.cssSelector("ul.boardView_listWrap"))
            ulBoard.findElements(By.id("bbs_gubun"))[0].click()
        }


    }

    private fun setProperty() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe")
        //WebDriver 프로퍼티 설정
    }

    /*fun script(key : String, value : String){
        //JavaScript 실행 구문 예시
        //js.executeScript("window.sessionStorage.setItem($key,$value);")
        val js = driver as JavascriptExecutor
        val button = driver.findElement(By.name("btnLogin"))
        js.executeScript("arguments[0].click();", element)
        val text = js.executeScript("return arguments[0].innerText", element)
        js.executeScript("console.log('hello world')")
    }*/
    fun analyseContext(title: String, text: String) {
        TODO("제목, 내용 String 안의 글을 분석할 method")
    }

    companion object {
        const val URL = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
    }
}