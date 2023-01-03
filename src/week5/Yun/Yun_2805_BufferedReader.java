package week5.Yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yun_2805_BufferedReader {  //시간초과

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] firstInput;

    static {
        try {
            firstInput = br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int numberOfTrees = Integer.parseInt(firstInput[0]);
    static int lengthOfTreeRequired = Integer.parseInt(firstInput[1]);
    static String[] stringLengthOfTrees;
    static int[] lengthOfTrees = new int[numberOfTrees];
    static int maxLengthOfTrees = 0;

    public static void main(String[] args) throws IOException {
        stringLengthOfTrees = br.readLine().split(" ");
        setLengthOfTrees();

        maxLengthOfTrees = getMaxLengthOfTrees(lengthOfTrees);
        System.out.println(getProperHeight());
    }

    private static void setLengthOfTrees() {
        for (int i = 0; i < stringLengthOfTrees.length; i++) {
            lengthOfTrees[i] = Integer.parseInt(stringLengthOfTrees[i]);
        }
    }

    private static int getMaxLengthOfTrees(int[] lengthOfTrees) {
        for (int i = 0; i < lengthOfTrees.length; i++) {
            maxLengthOfTrees = Math.max(maxLengthOfTrees, lengthOfTrees[i]);
        }
        return maxLengthOfTrees;
    }

    static int getProperHeight() {
        int leftHeight = 0;
        int rightHeight = maxLengthOfTrees;
        int lengthOfTreeCut = 0;

        int beforeMiddleHeight = 987_654_321;

        while (true) {
            int middleHeight = (leftHeight + rightHeight) / 2;

            if (middleHeight == beforeMiddleHeight) {
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
