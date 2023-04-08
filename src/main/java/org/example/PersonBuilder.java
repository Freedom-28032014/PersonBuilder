package org.example;
// ЗАДАЧА №1, также надо создать класс PersonBuilder для конструирования объектов класса Person.
// Объекту этого класса (далее - билдер) можно выставлять любые данные для будущего объекта класса
public class PersonBuilder {
    protected String name; // Имя (String). Каждый человек обязан иметь имя
    protected String surname; // Фамилия (String). Каждый человек обязан иметь фамилию
    protected int age; // Возраст (int).
    protected String city; // Текущий город жительства (String).

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        Person person = new Person(this.name, this.surname, this.age);
        person.setAddress(city);
        // ЗАДАЧА №1, не забудьте про IllegalArgumentException в случае ввода недопустимых данных
        if (name == null) throw new IllegalStateException("ОШИБКА: необходимо заполнить имя !");
        if (surname == null) throw new IllegalStateException("ОШИБКА: необходимо заполнить фамилию !");
        if (age < 0) throw new IllegalStateException("ОШИБКА: необходимо заполнить возраст !");

        return person; // возвращающий объект класса Person с указанными билдеру данными.
    }
}


