package com.application.coronaliveserver.domain.tool

class AnalyzeMethod(text: String) {
    var isKeywordCorrect : Boolean = false
    private val mText = text
    private var hasNumber = false
    private var hasQuantity = false
    private val condition = NumberingCondition(
            hasNumber,
            hasQuantity
    )
    fun analyze(){
        analyzeByKeyWord()
        if(isKeywordCorrect) {
            getLocation()
        }
    }
    private fun getLocation(){
        val localSplit = mText.indexOf("-송출지역-") + 6
        val locationName = mText.substring(localSplit)
        println(locationName)
        //송출 지역 이후의 글자를 가져오고 싶음, 더 해봐야함
    }
    private fun analyzeByKeyWord(){
        if(mText.indexOf("확진")!= -1 && mText.indexOf("발생")!= -1) {
                println("내용 : $mText\n")
                isKeywordCorrect = true
        }
    }
    private fun getPeople(){
        TODO("make algorithm to get number of people from context")
        // 경우의 수
        // <n명 발생>
        // 1-1. n명 발생 (m번째 확진자의 접촉자)
        // 1-3. 대도시 기준 구청에서 발생한 확진자를 모두 합해 시청에서 종합 발송할 경우
        // ex) [부산시] 1.12(화) 부산 코로나19 신규확진자 25명(동2,부산진5,남3,북1,해운대2,금정4,강서2,연제1,수영1,사상1,기장1,요양기관2)입니다.
        // <m번째 확진자 발생>
        // 2-1. 나열식 ( 100번, 101번, 102번 )
        // 2-2. 범위식 ( 100번 ~ 102번 )
        // 2-3. m번째 확진자 발생 (k번째 확진자의 접촉자)
        // 3. 둘 다의 경우
    }
    private fun hasNumberAndQuantity(text : String) : String{
        if(text.indexOf("명")!= -1){
            hasNumber = true
            if(text.indexOf("번")!= -1)
                hasQuantity = true
        }
        else if(text.indexOf("번")!= -1)
            hasQuantity = true
        return when(condition){
            ONLY_HAS_NUMBER -> "번"
            ONLY_HAS_QUANTITY -> "명"
            HAS_BOTH -> "둘다"
            else -> ""
            //regex 이용해 필요한 명/번 앞의 숫자를 가져와야 함
            //regex 외에도 split, Indexof 이후 substring 이용 가능
            //https://all-record.tistory.com/118
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