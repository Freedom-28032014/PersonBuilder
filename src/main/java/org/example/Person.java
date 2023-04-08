package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name; // Имя (String). Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
    protected final String surname; // Фамилия (String). Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
    protected int age; // Возраст (int).
    protected String city; // Текущий город жительства (String)

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Задача 1 Также в класс Person надо добавить метод PersonBuilder newChildBuilder(), который будет возвращать полузаполненный билдер для ребёнка, а именно:
    public PersonBuilder newChildBuilder() {
        //с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).
        return new PersonBuilder().setSurname(surname).setAddress(city);
    }

    public boolean hasAge() { // Задача №1 возраст человека может быть неизвестен, в этом случае метод
        if (age == 0) return false; // должен вернуть false
        return true; // иначе - true

    }

    public boolean hasAddress() { // Задача №2 текущий город жительства (String). Может быть известен в этом случае метод
        if (city != null && !city.isEmpty()) return true; // должен true
        return false; // иначе false

    }

    // Задача №1 Наполните класс Person методами, нужными для реализации поведения
    // объектов этого класса как описано выше в условии.

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) { // Задача №1, выставлен в любой через setAddress(String city)
        this.city = city;

    }

    public void happyBirthday() { // Задача №1, если возраст человека известен, то с момента создания объекта он
        if (hasAge()) age += 1; // может быть изменен только увеличением на единицу через вызов метода happyBirthday()
    }

    @Override
    public String toString() {
        return String.format("%s %s возраст %d из города %s", surname, name, age, city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}