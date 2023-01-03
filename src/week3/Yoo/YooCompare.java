package week3.Yoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://st-lab.tistory.com/243
public class YooCompare {

    public static void main(String[] args) {
        Student2 a = new Student2(17,2);
        Student2 b = new Student2(18,1);
        Student2 c = new Student2(19,2);

//        int isBig = a.compareTo(b);
//        int isBig = a.compare(b,c); //b와 c가 무관하게 a객체안의 compare을 이용.

        //익명의 객체 구현 , 1회성을 위해 객체구현을 하지않고 바로 메서드 정의
        Comparator<Student2> comp = new Comparator<Student2>() {
            @Override public int compare(Student2 o1, Student2 o2) {
                return o1.classNumber - o2.classNumber;
            }
        };

        int isBig = comp.compare(b,c);

        if(isBig > 0){
//            System.out.println("a is bigger than b");
            System.out.println("b is bigger than c");
        }else if(isBig == 0){
//            System.out.println("a eqauls b");
            System.out.println("c eqauls b");
        }else{
//            System.out.println("b is bigger than a");
            System.out.println("c is bigger than b");
        }
    }

}

class Student implements Comparable<Student>{

    int age;
    int classNumber;

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override public int compareTo(Student o) {
        return this.age - o.age;
    }
}

class Student2 implements Comparator<Student2>{

    int age;
    int classNumber;

    Student2(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override public int compare(Student2 o1, Student2 o2) {
        return o1.classNumber - o2.classNumber;
    }
}