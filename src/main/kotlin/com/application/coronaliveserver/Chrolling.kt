package com.application.coronaliveserver

import com.application.coronaliveserver.common.ApiResponse
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class Chrolling {
    val driver : WebDriver = ChromeDriver()
    val url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
    val iframe = driver.findElement(By.cssSelector("a.go_btn"))
    val js = driver as JavascriptExecutor
    fun navigate(){
        driver.get(url)
        driver.switchTo().frame(iframe)
        driver.findElement(By.tagName("button")).click()
        driver.findElements(By.id("bbs_tr_0_bbs_title"))[0].click()
        val errorCount = 0

        val rePlys = driver.findElement(By.cssSelector("div.boardView"))
        val tList = rePlys.findElements(By.id("sj"))
        val title = tList[0].text
        val text = rePlys.findElements(By.id("cn"))[0].text
        rePlys?.let {
            ApiResponse.ok(title + text)
        }?: throw Exception("불러온 데이터가 존재하지 없습니다.")



        }
    fun setProperty(){
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver")
    }
    fun script(key : String, value : String){
        js.executeScript("window.sessionStorage.setItem($key,$value);")
        /*val js = driver as JavascriptExecutor
        val button = driver.findElement(By.name("btnLogin"))
        js.executeScript("arguments[0].click();", element)
        val text = js.executeScript("return arguments[0].innerText", element)
        js.executeScript("console.log('hello world')")*/
    }
}