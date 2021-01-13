package com.application.coronaliveserver.tool

class AnalyzeMethod(text: String) {
    var isKeywordCorrect : Boolean = false
    private val mText = text
    fun analyze(){
        analyzeByKeyWord()
        getLocation()
    }
    private fun getLocation(){
        println(mText.lines().last())
    }
    private fun analyzeByKeyWord(){
        if(mText.indexOf("확진")!= -1) {
            println("내용 : $mText\n")
            isKeywordCorrect = true
        }
        else
            println("확진자 x : $mText\n")
    }
}