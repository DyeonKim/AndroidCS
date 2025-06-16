package com.example.javaapp.data;

import java.util.Arrays;
import java.util.List;

public class DataSet {
    public static List<Person> persons;

    static {
        try {
            persons = Arrays.asList(
                    new Person("김", "철수", 30, "M"),
                    new Person("김", "영수", 20, "M"),
                    new Person("김", "영희", 55, "F"),
                    new Person("최", "돌쇠", 12, "M"),
                    new Person("홍", "길동", 8, "M"),
                    new Person("정", "수지", 30, "F"),
                    new Person("이", "바다", 22, "F"),
                    new Person("이", "예지", 80, "F"),
                    new Person("박", "희민", 60, "F"),
                    new Person("곽", "철용", 33, "M")
            );
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
