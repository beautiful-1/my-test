package test.impl;

import test.C;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author LZN
 * @Title D
 * @ProjectName pattern
 * @Description
 * @date 2022-11-16 12:12
 **/
public class D implements C {
    @Override
    public String say() {
        return null;
    }

    @Override
    public int walk() {
        return 0;
    }

    @Override
    public String look() {
        return null;
    }
    static class Person{
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String firstName;
        public String lastName;
    }

    public static void main(String[] args) {

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));


        /*List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);*/
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }

}
