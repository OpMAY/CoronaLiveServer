package com.application.coronaliveserver.tool

class AnalyzeMethod(title: String, text: String) {
    private var isKeywordCorrect : Boolean = false
    private val mTitle = title
    private val mText = text
    fun analyze(){
        analyzeByKeyWord(mTitle, mText)
    }
    private fun analyzeByKeyWord(title : String, text : String){
        if(text.indexOf("확진")!= -1) {
            println("내용 : $text\n")
            isKeywordCorrect = true
        }
        else
            println("확진자 x : $text\n")
    }
}