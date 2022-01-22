package week8.Yoo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//완주하지 못한 선수
public class hash_1 {
    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    private static String solution(String[] participant, String[] completion) {
        //정렬 후 길이가 1차이 난다면
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        return participant[i];
    }
}
