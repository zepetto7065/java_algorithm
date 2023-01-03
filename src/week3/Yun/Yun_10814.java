package week3.Yun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Yun_10814 { // 216484	2184
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMember = scanner.nextInt();
        scanner.nextLine();

        Member[] members = new Member[numberOfMember];
        setmembers(scanner, numberOfMember, members);

        sorting(members);
        print(numberOfMember, members);
    }

    private static void print(int numberOfMember, Member[] members) {
        for (int i = 0; i < numberOfMember; i++) {
            System.out.println(members[i].age + " " + members[i].name);
        }
    }

    private static void sorting(Member[] members) {
        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age != o2.age) {
                    return o1.age - o2.age;
                }
                return o1.order - o2.order;
            }
        });
    }

    private static void setmembers(Scanner scanner, int numberOfMember, Member[] members) {
        for (int i = 0; i < numberOfMember; i++) {
            String[] input = scanner.nextLine().split(" ");
            members[i] = new Member(input[0], input[1], i);
        }
    }
}

class Member {
    int age;
    String name;
    int order;

    Member(int age, String name, int order) {
        this(Integer.toString(age), name, order);
    }

    Member(String age, String name, int order) {
        this.age = Integer.parseInt(age);
        this.name = name;
        this.order = order;
    }
}
