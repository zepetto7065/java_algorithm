package week11.Yoo;

import java.util.Arrays;

public class Yoo_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 10, 2};
        System.out.println(solution(numbers));
    }

    private static String solution(int[] numbers) {
        String answer = new String();
        String[] resultArray = new String[numbers.length];

        //int[] -> String[]
        for (int i = 0; i < numbers.length; i++){
            resultArray[i] = String.valueOf(numbers[i]);
        }

        //정렬
        Arrays.sort(resultArray, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        //0값을 중복으로 받을 경우, testcase 통과 못함
        //{0,0,0}
        if(resultArray[0].equals("0")) return "0";

        for (String s : resultArray) {
            answer += s;
        }

        return answer;
    }
}
