package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            Person brother = new PersonBuilder()
                    .setName("Данила")
                    .setAddress("Москва")
                    .setAge(2)
                    .build();
            System.out.println("У " + mom + " есть родной брат, " + brother);
            //new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            Person father = new PersonBuilder()
                    .setName("Дмитрий")
                    .setSurname("Вольф")
                    .setAddress("Сидней")
                    .setAge(-100)
                    .build();
            System.out.println("У " + mom + " есть муж, " + father);
            //new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}