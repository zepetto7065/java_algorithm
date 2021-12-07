package week2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YooTest {
    public void problem1() {
        String a = "9999";
        String b = "999";
        String answer = "";

        BigInteger aBig = new BigInteger(a);
        BigInteger bBig = new BigInteger(b);

        BigInteger add = aBig.add(bBig);
        answer = add.toString();

        System.out.println(answer);
    }

    public void problem1_1() {
        String a = "1234";
        String b = "5678";
        String answer = "";

        int max_length = Math.max(a.length(), b.length());
        int[] A = new int[max_length + 1];
        int[] B = new int[max_length + 1];

        for (int i = 0; i < a.length(); i++) {
            A[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            B[i] = b.charAt(b.length() - 1 - i) - '0';
        }

        //더한다
        for (int i = 0; i < max_length; i++) {
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] = A[i + 1] + (value / 10);
        }

        int count = 0;
        if (A[max_length] == 0) {
            count = max_length - 1;
        } else {
            count = max_length;
        }

        for (int i = count; i >= 0; i--) {
            answer += Integer.toString(A[i]);
        }
        System.out.println(answer);
    }

    public void problem2() {
        int[] stats = new int[] { 5, 2, 3, 1, 7, 8, 9, 10 };
        int answer = 0;
        List<List<Integer>> teams = new ArrayList<>();

        for (int i = 0; i < stats.length; i++) {
            boolean isAdd = false;
            //팀이 없을 경우
            if (i == 0) {
                teams.add(new ArrayList<>());
                teams.get(0).add(stats[0]);
                continue;
            }

            //각 팀의 최소값을 체크
            for (int j = 0; j < teams.size(); j++) {
                Integer max = Collections.max(teams.get(j));

                if (max < stats[i]) {
                    //있을 경우
                    teams.get(j).add(stats[i]);
                    isAdd = true;
                    break;
                }
            }

            //없으면 만들어줘
            if (!isAdd) {
                teams.add(new ArrayList<>());
                teams.get(teams.size() - 1).add(stats[i]);
            }

        }
        answer = teams.size();
        System.out.println(answer);
    }
}
