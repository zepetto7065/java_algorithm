package week3.Shin;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

// 나이순 정렬: https://www.acmicpc.net/problem/10814 - 2136ms
public class Shin_10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        IntStream.range(0, N)
                .mapToObj(i -> new Person(Integer.parseInt(sc.next()), sc.next()))
                .sorted(comparing(Person::getAge))
                .forEach(System.out::println);
    }

    static class Person {

        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
