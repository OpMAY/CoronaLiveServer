package com.application.coronaliveserver.tool

class AnalyzeMethod() {
    fun analyzeByKeyWord(title : String, text : String){
        if(text.indexOf("확진")!= -1)
            println("내용 : $text\n")
        else
            println("확진자 x : $text\n")
    }
}