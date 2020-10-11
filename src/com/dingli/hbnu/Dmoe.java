package com.dingli.hbnu;

public class Dmoe {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();

        Person.id = 20;

        System.out.println(person1.id);
        System.out.println(person2.id);
    }
}

class Person {
    String name;
    static int id = 10;

    public void change(int id) {
        System.out.println(id);
    }
}
