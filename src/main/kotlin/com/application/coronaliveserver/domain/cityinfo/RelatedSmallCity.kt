package com.application.coronaliveserver.domain.cityinfo

class RelatedSmallCity {
    fun getRelatedSmallCities(bigCity: Long): List<String> {
        when (bigCity) {
            SEOUL -> return SMALL_CITY_OF_SEOUL
            DAEJEON -> return SMALL_CITY_OF_DAEJEON
            DAEGU -> return SMALL_CITY_OF_DAEGU
            BUSAN -> return SMALL_CITY_OF_BUSAN
            ULSAN -> return SMALL_CITY_OF_ULSAN
            INCHEON -> return SMALL_CITY_OF_INCHEON
            GWANGJU -> return SMALL_CITY_OF_GWANGJU
            JEJU -> return SMALL_CITY_OF_JEJU
            GYEONGI -> return SMALL_CITY_OF_GYEONGI
            CHUNGCHEONGSOUTH -> return SMALL_CITY_OF_CHUNGCHEONGSOUTH
            CHUNGCHEONGNORTH -> return SMALL_CITY_OF_CHUNGCHEONGNORTH
            GYUNGSANGSOUTH -> return SMALL_CITY_OF_GYEONGSANGSOUTH
            GYUNGSANGNORTH -> return SMALL_CITY_OF_GYEONGSANGNORTH
            JEONLASOUTH -> return SMALL_CITY_OF_JEONLASOUTH
            JEONLANORTH -> return SMALL_CITY_OF_JEONLANORTH
            GANGWON -> return SMALL_CITY_OF_GANGWON
            SEJONG -> return SMALL_CITY_OF_SEJONG
            else -> throw IllegalStateException("올바르지 않은 접근입니다.")
        }
    }

    companion object {
        //BIG CITY NAMED
        const val SEOUL: Long = 0 //"서울특별시"
        const val DAEJEON: Long = 1 //"대전광역시"
        const val DAEGU: Long = 3 //"대구광역시"
        const val BUSAN: Long = 5 //"부산광역시"
        const val ULSAN: Long = 4 //"울산광역시"
        const val INCHEON: Long = 2 //"인천광역시"
        const val GWANGJU: Long = 6 //"광주광역시"
        const val JEJU: Long = 16 //"제주도"
        const val GYEONGI: Long = 8 //"경기도"
        const val CHUNGCHEONGSOUTH: Long = 9 //"충청남도"
        const val CHUNGCHEONGNORTH: Long = 10 //"충청북도"
        const val GYUNGSANGSOUTH: Long = 12 //"경상남도"
        const val GYUNGSANGNORTH: Long = 13 //"경상북도"
        const val JEONLASOUTH: Long = 14 //"전라남도"
        const val JEONLANORTH: Long = 15 //"전라북도"
        const val GANGWON: Long = 11 //"강원도"
        const val SEJONG: Long = 7 //"세종시"

        //LIST OF SMALL CITIES CONSIST OF BIG CITY
        val SMALL_CITY_OF_SEOUL = listOf("강남구", "강서구", "송파구", "광진구", "노원구", "강동구", "도봉구", "양천구", "구로구",
                "영등포구", "마포구", "서대문구", "관악구", "금천구", "서초구", "강북구", "성북구", "중랑구", "중구", "용산구", "동작구",
                "동대문구", "성동구", "종로구", "은평구")
        val SMALL_CITY_OF_DAEJEON = listOf("대덕구", "동구", "서구", "유성구", "중구")
        val SMALL_CITY_OF_INCHEON = listOf("강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구")
        val SMALL_CITY_OF_DAEGU = listOf("남구", "달서구", "달성군", "동구", "북구", "서구", "수성구", "중구")
        val SMALL_CITY_OF_BUSAN = listOf("강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구",
                "서구", "수영구", "연제구", "영도구", "중구", "해운대구")
        val SMALL_CITY_OF_ULSAN = listOf("남구", "동구", "북구", "울주군", "중구")
        val SMALL_CITY_OF_GWANGJU = listOf("광산구", "남구", "동구", "북구", "서구")
        val SMALL_CITY_OF_SEJONG = listOf("세종시")
        val SMALL_CITY_OF_JEJU = listOf("제주시", "서귀포시")
        val SMALL_CITY_OF_GYEONGI = listOf("가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시",
                "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군",
                "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시")
        val SMALL_CITY_OF_CHUNGCHEONGSOUTH = listOf("계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시",
                "서천군", "아산시", "예산군", "천안시", "청양군", "태안군", "흥성군")
        val SMALL_CITY_OF_CHUNGCHEONGNORTH = listOf("괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군",
                "진천군", "청주시", "충주시")
        val SMALL_CITY_OF_GANGWON = listOf("강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시",
                "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군")
        val SMALL_CITY_OF_GYEONGSANGSOUTH = listOf("거제시", "거창군", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군",
                "양산시", "의령군", "진주시", "창녕군", "창원시", "통영시", "하동군", "함안군", "함양군", "합천군")
        val SMALL_CITY_OF_GYEONGSANGNORTH = listOf("경산시", "경주시", "고령군", "구미시", "군위군", "김천시", "문경시", "봉화군",
                "상주시", "성주군", "안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군",
                "청송군", "칠곡군", "포항시")
        val SMALL_CITY_OF_JEONLASOUTH = listOf("강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군",
                "보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군")
        val SMALL_CITY_OF_JEONLANORTH = listOf("고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시",
                "임실군", "장수군", "전주시", "정읍시", "진안군")
    }
}