package week12.Yoo;

import java.util.List;
import java.util.stream.Collectors;

//틀림
public class Yoo_조이스틱 {
    public static void main(String[] args) {
        String name = "JAN"; //74 65 78
        System.out.println(solution(name));
    }

    private static int solution(String name) {
        int answer = 0;

        //String to ascii integer array
        List<Integer> asciiList = name.chars()
                .mapToObj(c -> (char) c)
                .map(c -> (int) c)
                .collect(Collectors.toList());

        for (Integer integer : asciiList) {
            System.out.println(integer);
        }

        for (int num : asciiList) {
            if (65 < num && num <= 77) {
                answer += num -65;
            }else if( num > 77){
                answer += 90 - num + 1;
            }else if(num == 65){
                continue;
            }
            answer += 1; //좌우 이동
        }

        return answer - 1; //마지막 이동 제외
    }
}
