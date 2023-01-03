package week5.Yun;

import java.util.Scanner;

public class Yun_2805 { //시간초과

    static Scanner scanner = new Scanner(System.in);
    static int numberOfTrees = scanner.nextInt();
    static int lengthOfTreeRequired = scanner.nextInt();
    static int[] lengthOfTrees = new int[numberOfTrees];
    static int maxLengthOfTrees = 0;

    public static void main(String[] args) {
        setLengthOfTrees(lengthOfTrees);
        maxLengthOfTrees = getMaxLengthOfTrees(lengthOfTrees);
        System.out.println(getProperHeight());
    }

    private static int getMaxLengthOfTrees(int[] lengthOfTrees) {
        for (int i = 0; i < lengthOfTrees.length; i++) {
            maxLengthOfTrees = Math.max(maxLengthOfTrees, lengthOfTrees[i]);
        }
        return maxLengthOfTrees;
    }

    private static void setLengthOfTrees(int[] lengthOfTrees) {
        for (int i = 0; i < lengthOfTrees.length; i++) {
            lengthOfTrees[i] = scanner.nextInt();
        }
    }

    static int getProperHeight() {
        int leftHeight = 0;
        int rightHeight = maxLengthOfTrees;
        int lengthOfTreeCut = 0;

        int beforeMiddleHeight = 987_654_321;

        while (true) {
            int middleHeight = (leftHeight + rightHeight) / 2;

            if (Math.abs(middleHeight - beforeMiddleHeight) <= 1) {
                for (int i = middleHeight + 1; i >= middleHeight - 1; i--) {
                    if (getLengthOfTreeCut(i) > lengthOfTreeRequired) {
                        return middleHeight;
                    }
                }
            }

            lengthOfTreeCut = getLengthOfTreeCut(middleHeight);

            if (lengthOfTreeCut == lengthOfTreeRequired) {
                return middleHeight;
            }

            if (lengthOfTreeCut > lengthOfTreeRequired) {
                leftHeight = middleHeight;
            }

            if (lengthOfTreeCut < lengthOfTreeRequired) {
                rightHeight = middleHeight;
            }

            beforeMiddleHeight = middleHeight;
        }

    }

    static int getLengthOfTreeCut(int height) {
        int sum = 0;
        for (int lengthOfTree : lengthOfTrees) {
            int a = lengthOfTree - height;
            if (a > 0) {
                sum += a;
            }
        }
        return sum;
    }
}
