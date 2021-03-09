package com.application.coronaliveserver.domain.tool

import java.io.*

class AnalyzeMethod(text: String) {
    var isKeywordCorrect : Boolean = false //수동처리용
    var isKeywordAuto : Boolean = false //자동처리용
    private val mText = text
    private var hasNumber = false
    private var hasQuantity = false
    private val condition = NumberingCondition(
            hasNumber,
            hasQuantity
    )
    var testFile = File("temporaryFile.txt") //임시저장소역할(이후 웹페이지나 대체예정)
    var autoFile = File("autoFile.txt") //자동 처리되는 내용
    var trashFile = File("trashFile.txt")
    var finalCount = 0
    var numberIndex = 0


    fun analyze(){

        firstFilter()

        if(isKeywordCorrect) {
            getLocation()
            analyzePrep()
        }
    }
    private fun getLocation(){
        val localSplit = mText.indexOf("-송출지역-") + 6
        val locationName = mText.substring(localSplit)
        println(locationName)
        testFile.appendText("$locationName")
        //송출 지역 이후의 글자를 가져오고 싶음, 더 해봐야함
    }
    private fun firstFilter(){
        if(mText.indexOf("확진")!= -1)//확진이라는 단어가 포함되어있다면
        {
            isKeywordCorrect = true
            println("내용 : $mText\n")//프린트로 해놓았지만 1차적 관리장소로 전송 혹은 일단저장
            testFile.appendText("내용 : $mText\n")
            //"if temporary space is avaliable send it, or save in DB for second evaluation")
        }
        else //1차필터링 이후의 문자들 존재
            trashFile.appendText("$mText\n")
    }
    private fun analyzePrep(){
        if(mText.indexOf("확진자")!= -1 && mText.indexOf("발생")!= -1) {
            //"analyze text into official count by auto")
            isKeywordAuto = true
            autoFile.appendText("내용 : $mText\n")

    }
    }// 확진과 발생이 포함될 경우 프린트하고 iskeywordcorrect값 참으로 반환
    private fun countFromNumber(text: String) : String{
        when(hasNumber){
            true -> {
                //변형전 원형형태 split과 저장 필요
                text.toRegex().replace(" ", "")
                println("$text") //제대로 대체되었는지 확인
                numberIndex = text.indexOf("명") -1
            }
        }


    }

    private fun getPeople(){
        TODO("make algorithm to get number of people from context")
        // 경우의 수
        // <n명 발생>
        // 1-1. n명 발생 (m번째 확진자의 접촉자)
        // 1-2. n명 발생 (기발표 x명) , n명 - x명 형태로 해야함
        // 1-3. 대도시 기준 구청에서 발생한 확진자를 모두 합해 시청에서 종합 발송할 경우 , 각 구청과 겹치는 경우가 많으려나? 그런 경우 우리가 수동처리해야함
        // ex) [부산시] 1.12(화) 부산 코로나19 신규확진자 25명(동2,부산진5,남3,북1,해운대2,금정4,강서2,연제1,수영1,사상1,기장1,요양기관2)입니다.
        // 1-4. x명 확진 , x명(해외~~명~~) 코로나19 확진
        // <m번째 확진자 발생>
        // 2-1. 나열식 ( 100번, 101번, 102번 )
        // 2-2-1. 범위식 ( 100번 ~ 102번 )
        // 2-2-2. 범위식 ( 1017 ~ 1019번)
        // 2-3. m번째 확진자 발생 (k번째 확진자의 접촉자)
        // !!2-4!!. x번 코로나19 확진자 발생 (단일 명수인 케이스)
        // 3. 둘 다의 경우
        // 4. 어제 x명 발생

        //이부분을 analyzeprep에 넣으면 됨
    }
    private fun hasNumberAndQuantity(text : String) : String{
        if(text.contains("명")){
            hasNumber = true
            if(text.contains("번"))
                hasQuantity = true
        }
        else if(text.contains("번"))
            hasQuantity = true
        return when(condition){
            ONLY_HAS_NUMBER -> "번"
            ONLY_HAS_QUANTITY -> "명"
            HAS_BOTH -> "둘다"
            else -> ""
            //regex 이용해 필요한 명/번 앞의 숫자를 가져와야 함
            //regex 외에도 split, Indexof 이후 substring 이용 가능
            //https://all-record.tistory.com/118

            //형태들이 다달라서 띄어쓰기, 코로나19 단어 삭제하고
            // 각 경우에 따른 명수 추출 analyzeprep과 연계하여 이용하며 컷팅된 데이터에서 명수 추출할 부분
            // 코로나19라는 문자에 수가 포함되어있어서 오류를 줄이기 위해 저 문구도 발견되는대로 삭제 하는게 나아보임
        }
    }

    data class NumberingCondition(
            val Number : Boolean,
            val Quantity : Boolean
    )
    companion object{
        val ONLY_HAS_NUMBER = NumberingCondition(Number = true, Quantity = false)
        val ONLY_HAS_QUANTITY = NumberingCondition(Number = false, Quantity = true)
        val HAS_BOTH = NumberingCondition(Number = true, Quantity = true)
    }
}