package com.example.fridgeapp.data.food
import com.example.fridgeapp.model.Nutrition

object FakeNutritionDb {
    private val data = listOf(
        Nutrition(title = "밥", calories = 200, protein = 4.2, fat = 0.4, carbs = 44.0, categories = "냉장", group = "곡류/전분"),
        Nutrition(title = "두부", calories = 76, protein = 8.0, fat = 4.8, carbs = 1.9, categories = "냉장", group = "콩/두류"),
        Nutrition(title = "가라지", calories = 78, protein = 14.8, fat = 1.3, carbs = 0.7, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "가리비", calories = 80, protein = 15.2, fat = 1.7, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "가물치", calories = 86, protein = 18.2, fat = 0.8, carbs = 0.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "가시오가피", calories = 76, protein = 5.7, fat = 0.7, carbs = 15.9, categories = "냉장", group = "채소류"),
        Nutrition(title = "가재", calories = 126, protein = 15.5, fat = 5.1, carbs = 3.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "가지", calories = 19, protein = 1.1, fat = 0.0, carbs = 4.4, categories = "냉장", group = "채소류"),
        Nutrition(title = "각시수랑", calories = 70, protein = 15.0, fat = 0.3, carbs = 0.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "간장", calories = 105, protein = 10.0, fat = 0.1, carbs = 9.0, categories = "냉장", group = "조미/발효"),
        Nutrition(title = "갈래곰보", calories = 12, protein = 0.9, fat = 0.2, carbs = 4.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "갈색", calories = 195, protein = 23.2, fat = 11.0, carbs = 0.8, categories = "냉장", group = "육류"),
        Nutrition(title = "갈치", calories = 91.0, protein = 18.8, fat = 1.2, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "감", calories = 57, protein = 0.4, fat = 0.1, carbs = 15.1, categories = "냉장", group = "과일류"),
        Nutrition(title = "감성돔", calories = 100.0, protein = 20.6, fat = 2.8, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "감자", calories = 64, protein = 1.8, fat = 0.0, carbs = 14.7, categories = "실온", group = "곡류/전분"),
        Nutrition(title = "감펭", calories = 83, protein = 19.0, fat = 0.3, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "갓", calories = 36, protein = 3.5, fat = 0.2, carbs = 7.3, categories = "냉장", group = "채소류"),
        Nutrition(title = "강낭콩", calories = 174, protein = 8.8, fat = 0.9, carbs = 32.4, categories = "실온", group = "콩/두류"),
        Nutrition(title = "강달이", calories = 110, protein = 14.9, fat = 5.0, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "강준치", calories = 90, protein = 18.7, fat = 1.1, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "개불", calories = 56, protein = 10.26, fat = 0.68, carbs = 1.55, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "갯가재", calories = 105, protein = 7.5, fat = 2.1, carbs = 13.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "갯강구", calories = 295, protein = 46.0, fat = 4.2, carbs = 15.4, categories = "냉장", group = "곤충/기타단백"),
        Nutrition(title = "갯기름나물", calories = 47, protein = 3.7, fat = 0.4, carbs = 9.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "거위", calories = 133, protein = 16.4, fat = 4.3, carbs = 6.3, categories = "냉장", group = "육류"),
        Nutrition(title = "거위고기", calories = 161, protein = 22.8, fat = 7.1, carbs = 0.0, categories = "냉장", group = "육류"),
        Nutrition(title = "거위알", calories = 193, protein = 13.2, fat = 14.1, carbs = 0.8, categories = "냉장", group = "난류"),
        Nutrition(title = "게", calories = 74, protein = 13.7, fat = 0.8, carbs = 2.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "게걸무", calories = 32, protein = 2.1, fat = 0.2, carbs = 7.0, categories = "냉장", group = "채소류"),
        Nutrition(title = "게르치", calories = 158, protein = 20.8, fat = 7.5, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "겨자", calories = 24, protein = 3.5, fat = 0.3, carbs = 3.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "경수채", calories = 26, protein = 1.7, fat = 0.2, carbs = 5.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "계란", calories = 136, protein = 12.9, fat = 8.2, carbs = 0.8, categories = "냉장", group = "난류"),
        Nutrition(title = "고구마", calories = 147, protein = 1.1, fat = 0.1, carbs = 35.5, categories = "실온", group = "곡류/전분"),
        Nutrition(title = "고둥", calories = 107, protein = 17.4, fat = 2.1, carbs = 3.4, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "고들빼기", calories = 29, protein = 1.6, fat = 0.5, carbs = 5.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "고등어", calories = 205, protein = 18.6, fat = 13.9, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "고래고기", calories = 111, protein = 26.5, fat = 0.5, carbs = 0.0, categories = "냉장", group = "육류"),
        Nutrition(title = "고려엉겅퀴", calories = 28, protein = 3.0, fat = 0.5, carbs = 4.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "고비", calories = 28, protein = 2.1, fat = 0.1, carbs = 6.2, categories = "냉장", group = "채소류"),
        Nutrition(title = "고사리", calories = 22, protein = 2.9, fat = 0.2, carbs = 3.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "고수", calories = 25, protein = 2.4, fat = 0.3, carbs = 4.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "고추", calories = 21, protein = 2.6, fat = 0.1, carbs = 3.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "고춧잎", calories = 45, protein = 5.1, fat = 0.3, carbs = 8.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "곤달비", calories = 32, protein = 2.8, fat = 0.6, carbs = 5.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "공심채", calories = 26, protein = 1.7, fat = 0.2, carbs = 5.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "구기자", calories = 50, protein = 6.3, fat = 1.1, carbs = 7.0, categories = "냉장", group = "과일류"),
        Nutrition(title = "구아바", calories = 33, protein = 0.6, fat = 0.1, carbs = 9.9, categories = "냉장", group = "과일류"),
        Nutrition(title = "구즈베리", calories = 51, protein = 1.0, fat = 0.1, carbs = 13.2, categories = "냉장", group = "과일류"),
        Nutrition(title = "국화꽃", calories = 25, protein = 1.4, fat = 0.0, carbs = 6.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "군소", calories = 35, protein = 6.8, fat = 0.6, carbs = 0.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "군평선이", calories = 103, protein = 18.5, fat = 2.6, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "귀리", calories = 388, protein = 9.9, fat = 8.8, carbs = 68.0, categories = "실온", group = "곡류/전분"),
        Nutrition(title = "귤", calories = 73, protein = 1.2, fat = 0.1, carbs = 18.8, categories = "냉장", group = "과일류"),
        Nutrition(title = "근대", calories = 18, protein = 1.8, fat = 0.2, carbs = 3.3, categories = "냉장", group = "채소류"),
        Nutrition(title = "기러기알", calories = 193, protein = 12.3, fat = 13.9, carbs = 2.4, categories = "냉장", group = "난류"),
        Nutrition(title = "기름종개", calories = 107, protein = 17.5, fat = 3.3, carbs = 0.5, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "기장", calories = 360, protein = 11.2, fat = 1.9, carbs = 74.6, categories = "실온", group = "곡류/전분"),
        Nutrition(title = "김치", calories = 37, protein = 3.3, fat = 0.4, carbs = 7.1, categories = "냉장", group = "조미/발효"),
        Nutrition(title = "깍두기", calories = 33, protein = 1.6, fat = 1.1, carbs = 4.2, categories = "냉장", group = "조미/발효"),
        Nutrition(title = "꺽저기", calories = 92, protein = 19.5, fat = 1.0, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꼬막", calories = 81.0, protein = 14.7, fat = 0.9, carbs = 3.6, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꼬시래기", calories = 17, protein = 1.8, fat = 0.2, carbs = 6.2, categories = "냉장", group = "해조류"),
        Nutrition(title = "꼬치고기", calories = 102, protein = 20.6, fat = 1.6, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꼴뚜기", calories = 78, protein = 13.6, fat = 1.8, carbs = 1.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꽁치", calories = 142, protein = 22.7, fat = 4.7, carbs = 0.4, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꽃게", calories = 87.0, protein = 18.1, fat = 1.1, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "꾸지뽕", calories = 85, protein = 5.1, fat = 0.5, carbs = 19.2, categories = "냉장", group = "과일류"),
        Nutrition(title = "꿀풀", calories = 48, protein = 1.6, fat = 0.2, carbs = 11.9, categories = "냉장", group = "채소류"),
        Nutrition(title = "꿩고기", calories = 124, protein = 27.5, fat = 0.8, carbs = 0.0, categories = "냉장", group = "육류"),
        Nutrition(title = "낙지", calories = 82, protein = 14.9, fat = 1.0, carbs = 2.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "날개콩", calories = 36, protein = 1.9, fat = 0.2, carbs = 6.5, categories = "실온", group = "콩/두류"),
        Nutrition(title = "날치", calories = 99, protein = 22.2, fat = 0.5, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "납지리", calories = 86, protein = 17.5, fat = 1.2, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "냉이", calories = 37, protein = 3.8, fat = 0.4, carbs = 6.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "넙치", calories = 91.0, protein = 19.0, fat = 1.2, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "놀래기", calories = 104, protein = 20.3, fat = 1.9, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "농어", calories = 97.0, protein = 20.0, fat = 2.0, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "누리장나무잎", calories = 65, protein = 4.5, fat = 1.0, carbs = 12.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "누치", calories = 105, protein = 17.3, fat = 3.0, carbs = 0.8, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "눈퉁멸", calories = 138, protein = 18.5, fat = 6.2, carbs = 0.4, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "는쟁이냉이", calories = 28, protein = 2.5, fat = 0.3, carbs = 5.4, categories = "냉장", group = "채소류"),
        Nutrition(title = "능성어", calories = 93, protein = 18.8, fat = 1.3, carbs = 0.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "다랑어", calories = 177, protein = 24.0, fat = 8.1, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "다래", calories = 67, protein = 1.6, fat = 0.4, carbs = 16.2, categories = "냉장", group = "과일류"),
        Nutrition(title = "다시마", calories = 43, protein = 1.7, fat = 0.6, carbs = 9.6, categories = "냉장", group = "해조류"),
        Nutrition(title = "다슬기", calories = 87, protein = 14.2, fat = 1.4, carbs = 2.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "달강어", calories = 121, protein = 19.7, fat = 4.0, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "달래", calories = 56, protein = 2.4, fat = 0.3, carbs = 13.4, categories = "냉장", group = "채소류"),
        Nutrition(title = "달팽이", calories = 90, protein = 16.1, fat = 1.4, carbs = 2.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "닭고기", calories = 342, protein = 15.1, fat = 29.6, carbs = 0.0, categories = "냉장", group = "육류"),
        Nutrition(title = "당귀", calories = 43, protein = 3.2, fat = 0.4, carbs = 8.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "당근", calories = 31, protein = 1.0, fat = 0.1, carbs = 7.0, categories = "냉장", group = "채소류"),
        Nutrition(title = "대구", calories = 82.0, protein = 17.8, fat = 0.7, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "대두어", calories = 96, protein = 17.5, fat = 2.1, carbs = 0.5, categories = "실온", group = "콩/두류"),
        Nutrition(title = "대수리", calories = 112, protein = 18.8, fat = 2.6, carbs = 1.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "대추", calories = 105, protein = 1.4, fat = 0.1, carbs = 27.6, categories = "냉장", group = "과일류"),
        Nutrition(title = "대파", calories = 29, protein = 1.2, fat = 0.2, carbs = 6.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "대합", calories = 62, protein = 12.0, fat = 0.8, carbs = 1.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "더덕", calories = 80, protein = 2.3, fat = 0.8, carbs = 17.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "덕대", calories = 74, protein = 14.6, fat = 1.3, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "도다리", calories = 86.0, protein = 18.0, fat = 1.3, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "도도바리", calories = 95, protein = 19.4, fat = 1.2, carbs = 0.5, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "도라지", calories = 65, protein = 2.0, fat = 0.1, carbs = 15.2, categories = "냉장", group = "채소류"),
        Nutrition(title = "도루묵", calories = 99.0, protein = 20.0, fat = 2.0, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "도치", calories = 62, protein = 7.2, fat = 3.0, carbs = 0.9, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "도토리", calories = 230, protein = 4.4, fat = 3.0, carbs = 46.7, categories = "냉장", group = "견과/씨앗")
        , Nutrition(title = "도화돔", calories = 130, protein = 21.3, fat = 4.3, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "돌나물", calories = 15, protein = 1.2, fat = 0.1, carbs = 3.2, categories = "냉장", group = "채소류")
        , Nutrition(title = "돌돔", calories = 117.0, protein = 23.0, fat = 2.4, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "돔", calories = 96, protein = 18.5, fat = 1.7, carbs = 0.4, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "동가리", calories = 82, protein = 19.2, fat = 0.1, carbs = 0.1, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "동부", calories = 166, protein = 9.5, fat = 1.0, carbs = 29.3, categories = "냉장", group = "콩/두류")
        , Nutrition(title = "동사리", calories = 81, protein = 16.9, fat = 1.0, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "동아", calories = 15, protein = 0.5, fat = 0.1, carbs = 3.8, categories = "냉장", group = "채소류")
        , Nutrition(title = "동자개", calories = 87, protein = 17.0, fat = 1.6, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "동충하초", calories = 27, protein = 5.6, fat = 0.4, carbs = 7.1, categories = "냉장", group = "버섯/균류")
        , Nutrition(title = "돼지고기", calories = 35, protein = 2.2, fat = 0.1, carbs = 14.9, categories = "냉장", group = "육류")
        , Nutrition(title = "된장", calories = 180, protein = 13, fat = 6, carbs = 18, categories = "냉장", group = "조미/발효")
        , Nutrition(title = "두릅", calories = 25, protein = 2.4, fat = 0.2, carbs = 4.8, categories = "냉장", group = "채소류")
        , Nutrition(title = "두리안", calories = 140, protein = 2.3, fat = 3.3, carbs = 27.1, categories = "냉장", group = "과일류")
        , Nutrition(title = "둑중개", calories = 104, protein = 15.0, fat = 4.2, carbs = 0.2, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "둥굴레", calories = 52, protein = 3.4, fat = 0.2, carbs = 11.7, categories = "냉장", group = "채소류")
        , Nutrition(title = "드렁허리", calories = 92, protein = 17.9, fat = 1.7, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "들기름", calories = 920, protein = 0.0, fat = 99.9, carbs = 0.1, categories = "실온", group = "유지/오일")
        , Nutrition(title = "들깨", calories = 17, protein = 1.7, fat = 0.1, carbs = 2.5, categories = "실온", group = "견과/씨앗")
        , Nutrition(title = "딸기", calories = 55, protein = 1.4, fat = 0.2, carbs = 13.6, categories = "냉장", group = "과일류")
        , Nutrition(title = "떡붕어", calories = 93, protein = 16.3, fat = 1.1, carbs = 3.4, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "라임", calories = 30, protein = 0.7, fat = 0.2, carbs = 10.5, categories = "냉장", group = "과일류")
        , Nutrition(title = "라즈베리", calories = 52, protein = 1.2, fat = 0.7, carbs = 11.9, categories = "냉장", group = "과일류")
        , Nutrition(title = "레몬", calories = 36, protein = 0.7, fat = 0.1, carbs = 9.3, categories = "냉장", group = "과일류")
        , Nutrition(title = "레몬그라스", calories = 99, protein = 1.8, fat = 0.5, carbs = 25.3, categories = "냉장", group = "채소류")
        , Nutrition(title = "롱안", calories = 60, protein = 1.3, fat = 0.1, carbs = 15.1, categories = "냉장", group = "과일류")
        , Nutrition(title = "루꼴라", calories = 26, protein = 3.2, fat = 0.4, carbs = 4.2, categories = "냉장", group = "채소류")
        , Nutrition(title = "리치", calories = 61, protein = 1.0, fat = 0.1, carbs = 16.4, categories = "냉장", group = "과일류")
        , Nutrition(title = "리크", calories = 54, protein = 1.8, fat = 0.3, carbs = 13.2, categories = "냉장", group = "채소류")
        , Nutrition(title = "마", calories = 63, protein = 1.8, fat = 0.1, carbs = 14.1, categories = "냉장", group = "곡류/전분")
        , Nutrition(title = "마가목", calories = 115, protein = 1.3, fat = 0.8, carbs = 25.5, categories = "냉장", group = "과일류")
        , Nutrition(title = "마늘", calories = 128, protein = 7.5, fat = 0.2, carbs = 26.4, categories = "실온", group = "채소류")
        , Nutrition(title = "마름", calories = 183, protein = 5.8, fat = 0.5, carbs = 40.6, categories = "냉장", group = "곡류/전분")
        , Nutrition(title = "마타리", calories = 45, protein = 2.1, fat = 0.1, carbs = 10.9, categories = "냉장", group = "채소류")
        , Nutrition(title = "만새기", calories = 100, protein = 21.3, fat = 1.9, carbs = 0.0, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "말고기", calories = 102, protein = 20.1, fat = 2.5, carbs = 0.3, categories = "냉장", group = "육류")
        , Nutrition(title = "망고", calories = 59, protein = 0.7, fat = 0.1, carbs = 15.4, categories = "냉장", group = "과일류")
        , Nutrition(title = "망고스틴", calories = 71, protein = 0.6, fat = 0.2, carbs = 17.5, categories = "냉장", group = "과일류")
        , Nutrition(title = "망둑어", calories = 77, protein = 16.4, fat = 0.7, carbs = 0.3, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "망상어", calories = 89, protein = 18.9, fat = 0.9, carbs = 0.2, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "매생이", calories = 12, protein = 1.8, fat = 0.3, carbs = 2.1, categories = "냉장", group = "해조류")
        , Nutrition(title = "매실", calories = 41, protein = 1.1, fat = 1.1, carbs = 7.8, categories = "냉장", group = "과일류")
        , Nutrition(title = "매퉁이", calories = 116, protein = 22.7, fat = 2.0, carbs = 0.3, categories = "냉장", group = "어패류/해산물")
        , Nutrition(title = "머루", calories = 79, protein = 1.5, fat = 0.9, carbs = 18.3, categories = "냉장", group = "과일류")
        , Nutrition(title = "머루씨", calories = 282, protein = 6.3, fat = 4.8, carbs = 54.0, categories = "냉장", group = "견과/씨앗")
        , Nutrition(title = "머위", calories = 17, protein = 2.3, fat = 0.1, carbs = 2.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "장어", calories = 184, protein = 18.4, fat = 11.7, carbs = 0.0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "잠두", calories = 341, protein = 26.1, fat = 1.5, carbs = 58.3, categories = "냉장", group = "곡류/서류"),
        Nutrition(title = "잣", calories = 658, protein = 16.6, fat = 65.7, carbs = 12.5, categories = "냉장", group = "견과/종실류"),
        Nutrition(title = "장갱이", calories = 90, protein = 19.1, fat = 1, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "장어", calories = 223, protein = 14.4, fat = 17.1, carbs = 0.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "잭프루트", calories = 95, protein = 1.7, fat = 0.6, carbs = 23.2, categories = "냉장", group = "과일류"),
        Nutrition(title = "적양무", calories = 19, protein = 2.5, fat = 0.4, carbs = 2.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "점줄우럭", calories = 111, protein = 19.3, fat = 1.9, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "정어리", calories = 132, protein = 21.3, fat = 4.5, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "제비쑥", calories = 35, protein = 4.5, fat = 0.7, carbs = 5, categories = "냉장", group = "채소류"),
        Nutrition(title = "조", calories = 373, protein = 11.5, fat = 3.9, carbs = 71.7, categories = "실온", group = "곡류/서류"),
        Nutrition(title = "조기", calories = 104, protein = 17.6, fat = 3.1, carbs = 0.1, categories = "실온", group = "어패류/해산물"),
        Nutrition(title = "조뱅이", calories = 47, protein = 4, fat = 0.2, carbs = 10.1, categories = "실온", group = "채소류"),
        Nutrition(title = "종어", calories = 74, protein = 15.8, fat = 0.8, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "준치", calories = 129, protein = 20.1, fat = 4.7, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "진달래꽃", calories = 26, protein = 1, fat = 0.1, carbs = 6.3, categories = "냉장", group = "채소류"),
        Nutrition(title = "질경이", calories = 48, protein = 3, fat = 0.2, carbs = 10.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "쪽파", calories = 26, protein = 1.7, fat = 0.2, carbs = 5.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "참기름", calories = 920, protein = 0, fat = 99.8, carbs = 0.1, categories = "실온", group = "기타"),
        Nutrition(title = "참나물", calories = 39, protein = 3.5, fat = 0.4, carbs = 7.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "참마자", calories = 90, protein = 17.7, fat = 1.5, carbs = 0.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "참붕어", calories = 118, protein = 16.4, fat = 5.1, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "참빗살나무", calories = 61, protein = 7.4, fat = 0.7, carbs = 10.3, categories = "냉장", group = "채소류"),
        Nutrition(title = "참외", calories = 40, protein = 0.6, fat = 0, carbs = 10.5, categories = "냉장", group = "과일류"),
        Nutrition(title = "천마", calories = 77, protein = 0.9, fat = 0, carbs = 18.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "청각", calories = 8, protein = 1.4, fat = 0.4, carbs = 1.6, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "청경채", calories = 10, protein = 1.4, fat = 0.1, carbs = 1.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "청새치", calories = 107, protein = 23.1, fat = 1.8, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "체리", calories = 57, protein = 1.4, fat = 0.1, carbs = 14.3, categories = "냉장", group = "과일류"),
        Nutrition(title = "초석잠", calories = 76, protein = 2.3, fat = 0.6, carbs = 17, categories = "냉장", group = "채소류"),
        Nutrition(title = "초어", calories = 89, protein = 17.1, fat = 1.7, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "총각무", calories = 23, protein = 2, fat = 0.3, carbs = 4.2, categories = "냉장", group = "채소류"),
        Nutrition(title = "취나물", calories = 51, protein = 2.6, fat = 0.4, carbs = 11.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "치자꽃", calories = 66, protein = 1.3, fat = 0.1, carbs = 14.9, categories = "냉장", group = "채소류"),
        Nutrition(title = "칡뿌리", calories = 137, protein = 2.5, fat = 0.1, carbs = 32, categories = "냉장", group = "채소류"),
        Nutrition(title = "케일", calories = 26, protein = 3.1, fat = 0.2, carbs = 4.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "콜라비", calories = 22, protein = 1.2, fat = 0.1, carbs = 5.2, categories = "냉장", group = "채소류"),
        Nutrition(title = "콩나물", calories = 43, protein = 4.7, fat = 1.2, carbs = 3.4, categories = "실온", group = "곡류/서류"),
        Nutrition(title = "콩잎", calories = 94, protein = 6.6, fat = 0.3, carbs = 21, categories = "실온", group = "채소류"),
        Nutrition(title = "크랜베리", calories = 46, protein = 0.5, fat = 0.1, carbs = 12, categories = "냉장", group = "과일류"),
        Nutrition(title = "크릴", calories = 76, protein = 12.1, fat = 2.6, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "큰논우렁이", calories = 71, protein = 9.8, fat = 1, carbs = 4.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "키위", calories = 54, protein = 0.8, fat = 0.3, carbs = 13.7, categories = "냉장", group = "과일류"),
        Nutrition(title = "탱자", calories = 84, protein = 1.3, fat = 1.5, carbs = 18.5, categories = "냉장", group = "과일류"),
        Nutrition(title = "토끼고기", calories = 135, protein = 21.7, fat = 4.4, carbs = 0.6, categories = "냉장", group = "육류"),
        Nutrition(title = "토란", calories = 71, protein = 2.1, fat = 0.1, carbs = 15.8, categories = "냉장", group = "채소류"),
        Nutrition(title = "토란대", calories = 16, protein = 0.3, fat = 0.1, carbs = 4.2, categories = "냉장", group = "채소류"),
        Nutrition(title = "토마토", calories = 19, protein = 1, fat = 0.2, carbs = 4.3, categories = "실온", group = "채소류"),
        Nutrition(title = "토스카노", calories = 40, protein = 4.7, fat = 0.6, carbs = 6.7, categories = "냉장", group = "채소류"),
        Nutrition(title = "통구멍", calories = 82, protein = 18.2, fat = 0.5, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "통치", calories = 138, protein = 20, fat = 5.7, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "투라치", calories = 79, protein = 18.1, fat = 0.1, carbs = 0.5, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "퉁퉁마디", calories = 19, protein = 1.4, fat = 0.1, carbs = 4, categories = "냉장", group = "채소류"),
        Nutrition(title = "틸라피아", calories = 126, protein = 19.3, fat = 4.7, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "파드득나물", calories = 25, protein = 1.8, fat = 0.1, carbs = 5.5, categories = "냉장", group = "채소류"),
        Nutrition(title = "파래", calories = 11, protein = 2.2, fat = 0.1, carbs = 3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "파슬리", calories = 20, protein = 2.4, fat = 0.3, carbs = 3.4, categories = "냉장", group = "채소류"),
        Nutrition(title = "파인애플", calories = 53, protein = 0.5, fat = 0.1, carbs = 14.1, categories = "실온", group = "과일류"),
        Nutrition(title = "파파야", calories = 40, protein = 0.7, fat = 0.1, carbs = 10.2, categories = "냉장", group = "과일류"),
        Nutrition(title = "페퍼민트", calories = 70, protein = 3.8, fat = 0.9, carbs = 14.9, categories = "냉장", group = "채소류"),
        Nutrition(title = "포도", calories = 60, protein = 0.4, fat = 0.3, carbs = 15.7, categories = "냉장", group = "과일류"),
        Nutrition(title = "포타벨라", calories = 16, protein = 3.3, fat = 0.1, carbs = 4.6, categories = "냉장", group = "버섯류"),
        Nutrition(title = "풀반지", calories = 167, protein = 16.9, fat = 10.1, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "플럼코트", calories = 47, protein = 0.6, fat = 1.1, carbs = 10, categories = "냉장", group = "과일류"),
        Nutrition(title = "피", calories = 376, protein = 8.5, fat = 4.6, carbs = 73.9, categories = "냉장", group = "곡류/서류"),
        Nutrition(title = "해바라기", calories = 9, protein = 2.2, fat = 0.1, carbs = 0.9, categories = "냉장", group = "견과/종실류"),
        Nutrition(title = "해삼", calories = 24, protein = 3.7, fat = 0.4, carbs = 1.3, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "해파리", calories = 6, protein = 1.3, fat = 0, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "호밀", calories = 334, protein = 15.9, fat = 1.5, carbs = 70.7, categories = "실온", group = "곡류/서류"),
        Nutrition(title = "호박", calories = 38, protein = 4.5, fat = 1.7, carbs = 3.6, categories = "실온", group = "채소류"),
        Nutrition(title = "홍치", calories = 93, protein = 18.9, fat = 1.4, carbs = 0.1, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "홍합", calories = 90, protein = 15.2, fat = 2.5, carbs = 0.4, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "홑잎나물", calories = 96, protein = 4.8, fat = 0.8, carbs = 21.6, categories = "냉장", group = "채소류"),
        Nutrition(title = "황새치", calories = 81, protein = 17, fat = 1, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "황소개구리", calories = 75, protein = 16.1, fat = 0.4, carbs = 0.7, categories = "냉장", group = "기타"),
        Nutrition(title = "황어", calories = 95, protein = 18.3, fat = 1.8, carbs = 0.2, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "횟대", calories = 69, protein = 7.2, fat = 3, carbs = 0.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "흰점박이", calories = 122, protein = 15.8, fat = 5.2, carbs = 2.9, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "히메치", calories = 99, protein = 20.9, fat = 1.1, carbs = 0, categories = "냉장", group = "어패류/해산물"),
        Nutrition(title = "히카마", calories = 44, protein = 0.7, fat = 0.1, carbs = 10.4, categories = "냉장", group = "채소류")
    )

    private fun norm(s: String) = s.trim().lowercase()

    fun findByName(name: String): Nutrition? {
        val key = norm(name)
        return data.firstOrNull { it.title?.let(::norm) == key }
    }
    // 그룹 목록 (정렬 & 중복 제거)
    fun groups(): List<String> =
        data.mapNotNull { it.group }.distinct().sorted()

    // 특정 그룹의 타이틀 목록
    fun titlesByGroup(group: String): List<String> =
        data.filter { it.group == group }
            .mapNotNull { it.title }
            .distinct()
            .sorted()

    // 특정 그룹 + 키워드 필터(자동완성용)
    fun titlesByGroupFiltered(group: String, keyword: String): List<String> {
        val base = titlesByGroup(group)
        if (keyword.isBlank()) return base.take(50)
        return base.filter { it.contains(keyword, ignoreCase = true) }.take(50)
    }
}