package week5.Yun;

import java.util.Scanner;

public class Yun_1654 {  // 틀렸습니다.
    static Scanner scanner = new Scanner(System.in);
    static int k = scanner.nextInt();
    static int n = scanner.nextInt();
    static int[] lengthOfCables = new int[k];

    public static void main(String[] args) {
        for (int i = 0; i < k; i++) {
            lengthOfCables[i] = scanner.nextInt();
        }

        int totalLengthOfCable = 0;
        for (int lengthOfCable : lengthOfCables) {
            totalLengthOfCable += lengthOfCable;
        }

        int maxLengthOfCable = totalLengthOfCable / n;

        System.out.println(getMaximumLength(maxLengthOfCable));

    }


    static boolean isPossible(int i) {
        int numberOfcable = 0;
        for (int lengthOfCable : lengthOfCables) {
            numberOfcable += lengthOfCable / i;
        }
        if (numberOfcable >= n) {
            return true;
        }
        return false;
    }

    static int getMaximumLength(int maxLengthOfCable) {
        int leftLength = 0;
        int rightLength = maxLengthOfCable;

        if (isPossible(rightLength)) {
            return rightLength;
        }
        int beforeMiddleLength = 987_654_321;
        int middleLength = 0;

        while (true) {
            middleLength = (leftLength + rightLength) / 2;

            if (Math.abs(middleLength - beforeMiddleLength) < 2) {
                for (int i = rightLength + 1; i >= rightLength - 1; i--) {
                    if (isPossible(i) == true) {
                        return i;
                    }
                }
            }

            boolean isMiddleLengthPossible = isPossible(middleLength);

            if (isMiddleLengthPossible == true) {
                leftLength = middleLength;
            }

            if (isMiddleLengthPossible == false) {
                rightLength = middleLength;
            }

            beforeMiddleLength = middleLength;
        }
    }
}
