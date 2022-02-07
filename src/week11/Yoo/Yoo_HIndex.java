package week11.Yoo;

import java.util.Arrays;

//https://yubh1017.tistory.com/23
public class Yoo_HIndex {
    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        solution(citations);
    }

    private static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int h;
        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;

            if(citations[i]>=h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
