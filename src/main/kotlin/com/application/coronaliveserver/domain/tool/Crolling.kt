package com.application.coronaliveserver.domain.tool

import com.application.coronaliveserver.domain.smalldata.SEDService
import com.application.coronaliveserver.domain.smalldata.SmallEssentialData
import com.application.coronaliveserver.domain.smalldata.SmallEssentialDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit
import java.util.logging.Handler

class Crolling {
    private lateinit var mtitle: String
    private lateinit var mtext: String
    var dailyTotalInfectedKorea: MutableMap<String, Int> = mutableMapOf("" to 0)
    var dailyTotalIncreasedInfectedKorea: MutableMap<String, Int> = mutableMapOf("" to 0)
    var dailyCoronaPhaseInfo: MutableMap<String, String> = mutableMapOf("" to "")
    var pNum: Int = 0
    var alertMessage: MutableMap<Int, String> = mutableMapOf(0 to "")

    //거리두기 단계 정보
    fun navigateLocalAlertPhaseInfo() {
        // Set driver System path property
        setProperty()
        // Set selenium chrome options
        val driver = driverSet()

        driver.get(localAlertPhaseInfoURL)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay

        val timetable = driver.findElement(By.className("info")).text
        println(timetable)

        for (i in 0..1) {
            val getKoreaAlertPhase = driver.findElements(By.className("rssd_title_2"))[i].text
            println(getKoreaAlertPhase)

            val getKoreaAlertPhaseSpecific = driver.findElements(By.className("rssd_descript"))[i].text
            println(getKoreaAlertPhaseSpecific)
        }
        for (i in 1..17) {
            val k = i + 1
            driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[3]/div[1]/div[2]/div/button[$i]"))
                .sendKeys(Keys.ENTER)
            val title1 =
                driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[3]/div[2]/div/div[$k]/h3")).text
            val title2 =
                driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[3]/div[2]/div/div[$k]/h4")).text
            val p = driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[3]/div[2]/div/div[$k]/p")).text
            println(title1)
            println(title2)
            println(p)

            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay
        }
        //Stop Crolling Driver
        driver.quit()

    }

    //당일 확진자 정보
    fun navigateDailyLocalCoronaInfectedInfo() {
        // Set driver System path property
        setProperty()
        // Set selenium chrome options
        val driver = driverSet()

        driver.get(dailyCoronaInfectedInfoURL)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay


        for (i in 1..19) {
            val locationName = driver.findElements(By.xpath("//table/tbody/tr[$i]/th"))
            val localInfectedNum = driver.findElements(By.xpath("//table/tbody/tr[$i]/td"))
            val increasedNum = localInfectedNum[0].text.replace(",", "").toInt()
            val totalNum = localInfectedNum[3].text.replace(",", "").toInt()
            println(locationName[0].text + " 확진환자 수 : " + localInfectedNum[3].text)
            println(locationName[0].text + " 증가량 : " + increasedNum.toString())
            dailyTotalInfectedKorea[locationName[0].text] = totalNum
            dailyTotalIncreasedInfectedKorea[locationName[0].text] = increasedNum

        }
        //Stop Crolling Driver
        driver.quit()

    }

    //재난문자 정보
    fun navigateLiveMessage() {
        // Set driver System path property
        setProperty()
        // Set selenium chrome options
        val driver = driverSet()

        val js = driver as JavascriptExecutor // Execute JavaScript from driver
        var startPage = 174 // Start Page
        val count = 12 // 가져올 글 갯수
        var selectNum = 0

        //URL OPEN
        driver.get(liveAlertMessageURL)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay

        //PAGE SET
        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
        driver.findElement(By.cssSelector("a.go_btn")).sendKeys(Keys.ENTER)
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay

        Thread.sleep(500)
        //글의 번호 가져오기
        for(i in 0..9){
            if(driver.findElement(By.id("bbs_tr_${i}_num_td")).text.toInt() == 3864) {
                pNum = driver.findElement(By.id("bbs_tr_${i}_num_td")).text.toInt()
                selectNum = i
                break
            }else{
                if(i == 9){
                    println("No number on this page")
                    if(driver.findElement(By.id("bbs_tr_${i}_num_td")).text.toInt() - 3864 > 0) { //해당 경우 외엔 들어올 수 없음
                        val numberDifference = driver.findElement(By.id("bbs_tr_${i}_num_td")).text.toInt() - 3864
                        startPage += numberDifference.div(10) + 1
                        js.executeScript("document.getElementById('bbs_page').value = $startPage;")
                        driver.findElement(By.cssSelector("a.go_btn")).sendKeys(Keys.ENTER)
                        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS)

                        Thread.sleep(500)
                        for(j in 0..9){
                            if(driver.findElement(By.id("bbs_tr_${j}_num_td")).text.toInt() == 3864) {
                                pNum = driver.findElement(By.id("bbs_tr_${j}_num_td")).text.toInt()
                                selectNum = j
                                break
                            }
                            else
                                println("Not matched Number in $j. Current Number : ${driver.findElement(By.id("bbs_tr_${j}_num_td")).text.toInt()} ")
                        }
                    }
                }
                else
                    println("Not matched Number in $i. Current Number : ${driver.findElement(By.id("bbs_tr_${i}_num_td")).text.toInt()} ")
            }
        }
        pNum = driver.findElement(By.id("bbs_tr_${selectNum}_num_td")).text.toInt()
        println(pNum)
        GlobalScope.launch(Dispatchers.Default) {
            //여기엔 뭐 넣으려고 했음?
        }
        //CLICK POST
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) // 0.5s delay
        driver.findElements(By.id("bbs_tr_${selectNum}_bbs_title"))[0].sendKeys(Keys.ENTER)
        var infectedMessage = 0
        for (i in 1..count) {
            //Find Article
            val rePlys = driver.findElement(By.cssSelector("div.boardView")) // 글 content의 위치
            val tList = rePlys.findElements(By.id("sj"))
            mtitle = tList[0].text
            mtext = rePlys.findElements(By.id("cn"))[0].text
            val analyzeMethod = AnalyzeMethod(mtext)
            analyzeMethod.analyze()
            if (analyzeMethod.isKeywordCorrect) {
                infectedMessage++
                println("확진자 문자 갯수 : $infectedMessage")
            }

            //Next Article
            val ulBoard = driver.findElement(By.cssSelector("ul.boardView_listWrap"))
            ulBoard.findElements(By.id("bbs_gubun"))[0].click()
        }
        //Stop Crolling Driver
        driver.quit()

    }

    fun autoUpdate() {
        setProperty()
        val driver = driverSet()
        // Server Update Link
        driver.get("http://localhost:8080/api/v1/update_data")
        driver.quit()
    }

    private fun driverSet(): WebDriver {
        // Set selenium chrome options
        val options = ChromeOptions()
        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
        options.addArguments("lang=ko_KR")
        options.addArguments("--window-size=1920,1080")
        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        return ChromeDriver(options)
    }

    private fun setProperty() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe")
        //WebDriver 프로퍼티 설정
    }

    companion object {
        const val liveAlertMessageURL =
            "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/sfc/dis/disasterMsgList.jsp?menuSeq=679"
        const val dailyCoronaInfectedInfoURL =
            "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun="
        const val localAlertPhaseInfoURL =
            "http://ncov.mohw.go.kr/regSocdisBoardView.do?brdId=6&brdGubun=68&ncvContSeq=495"
    }
}