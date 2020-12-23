package com.application.coronaliveserver

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class Crolling {

    fun navigate(){
        setProperty()
        val driver : WebDriver = ChromeDriver()

        val js = driver as JavascriptExecutor
        val startPage = 1
        val count = 10
        driver.get(URL)
        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
        driver.findElement(By.cssSelector("a.go_btn"))
        driver.findElement(By.tagName("button")).click()
        driver.findElements(By.id("bbs_tr_0_bbs_title"))[0].click()
        val errorCount = 0
        for(i in startPage..count) {
            val rePlys = driver.findElement(By.cssSelector("div.boardView"))
            val tList = rePlys.findElements(By.id("sj"))
            val title = tList[0].text
            val text = rePlys.findElements(By.id("cn"))[0].text
            println("$i \n제목 : $title")
            println("내용 : $text\n")
            val ulBoard = driver.findElement(By.cssSelector("ul.boardView_listWrap"))
            ulBoard.findElements(By.id("bbs_gubun"))[0].click()
        }



        }
    private fun setProperty(){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe")

    }
    fun script(key : String, value : String){
        //자바스크립트 실행 구문 예시
        //js.executeScript("window.sessionStorage.setItem($key,$value);")
        /*val js = driver as JavascriptExecutor
        val button = driver.findElement(By.name("btnLogin"))
        js.executeScript("arguments[0].click();", element)
        val text = js.executeScript("return arguments[0].innerText", element)
        js.executeScript("console.log('hello world')")*/
    }

    companion object{
        val URL = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
    }
}