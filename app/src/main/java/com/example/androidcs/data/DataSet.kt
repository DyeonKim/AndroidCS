package com.example.androidcs.data

object DataSet {
    val persons = listOf(
        Person("김", "철수", 30, "M"),
        Person("김", "영수", 20, "M"),
        Person("김", "영희", 55, "F"),
        Person("최", "돌쇠", 12, "M"),
        Person("홍", "길동", 8, "M"),
        Person("정", "수지", 30, "F"),
        Person("이", "바다", 22, "F"),
        Person("이", "예지", 80, "F"),
        Person("박", "희민", 60, "F"),
        Person("곽", "철용", 33, "M"),
        Person(lastName = "철용", firstName = "곽", age = 33, gender = "M"),
    )
}