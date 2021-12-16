package week3.Yoo;

public class YooCountingSort {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        int[] count = new int[30];
        int[] result = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 11); // 1~10의 임의수를 넣는다.
        }

        //number의 값을 Index로 하는 count 값 1씩 증가
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }

        //count2 구해주기
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int value = numbers[i];
            count[value]--;
            result[count[value]] = value;
        }

        // 초기 배열
        System.out.println("array[]");
        for (int i = 0; i < numbers.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(numbers[i] + "\t");
        }
        System.out.println("\n\n");

        // count
        System.out.println("count");
        for (int i = 0; i < count.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(count[i] + "\t");
        }
        System.out.println("\n\n");

        // 정렬된 배열
        System.out.println("result[]");
        for (int i = 0; i < result.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }
}
