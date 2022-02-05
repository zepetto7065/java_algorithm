package week10.Shin.lambda;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Apple redApple = new Apple(10, "Red");
        Apple orangeApple = new Apple(20, "Orange");

        List<Apple> list = List.of(redApple, orangeApple);

        // 전략 패턴
        ApplePredicate redApplePredicate = new RedApplePredicate();
        List<Apple> redApples = filter(list, redApplePredicate);
        System.out.println(redApples.size());

        ApplePredicate orangeApplePredicate = new OrangeApplePredicate();
        List<Apple> orangeApples = filter(list, orangeApplePredicate);
        System.out.println(orangeApples.size());

        // 템플릿 콜백 패턴 - 익명 클래스
        List<Apple> orangeApples2 = filter(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("Orange");
            }
        });
        System.out.println(orangeApples2.size());


        // 템플릿 콜백 패턴 - 람다식
        List<Apple> orangeApples3 = filter(list, apple -> apple.getColor().equals("Orange"));
        System.out.println(orangeApples3.size());
    }

    static class RedApplePredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("Red");
        }
    }

    static class OrangeApplePredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("Orange");
        }
    }

    static List<Apple> filter(List<Apple> list, ApplePredicate preedicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (preedicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
