package com.example.androidcs.data

data class Person(
    val firstName: String = "",
    val lastName: String,
    val age: Int = 0,
    val gender: String,
) {
    init {
        if (lastName.isBlank())
            throw IllegalArgumentException("이름은 공백 제외 한 글자 이상 이어야 합니다.")
        if (age < 0)
            throw IllegalArgumentException("나이는 음수를 입력할 수 없습니다.")
    }
}

fun Person.getFullName() = "${if (firstName.isNotBlank()) "$firstName " else ""}$lastName"
