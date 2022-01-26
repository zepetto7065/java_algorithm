package week8.Yoo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//위장
public class Hash_3 {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] clothe : clothes){
            //있음 가져오고 아니면 0  거기에 + 1해서 가져온다. 옷추가
            map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);
        }

        Iterator<Integer> iterator = map.values().iterator();

        while(iterator.hasNext()){
            // 1개 더해서 곱해준다.
            answer *= iterator.next().intValue() + 1;
        }

        answer -= 1;

        return answer;
    }


}
