package com.example.javaapp.data;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, int age, String gender) throws IllegalAccessException {
        if (lastName.isEmpty() || lastName.trim().length() == 0)
            throw new IllegalAccessException("이름은 공백 제외 한 글자 이상 이어야 합니다.");
        if (age < 0)
            throw new IllegalAccessException("나이는 음수를 입력할 수 없습니다.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, String gender) throws IllegalAccessException {
        this(firstName, lastName, 0, gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFullName() {
        if (firstName != null && firstName.trim().length() != 0)
            return firstName + " " + lastName;
        else
            return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender);
    }
}
