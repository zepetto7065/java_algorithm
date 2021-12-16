package week3.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//353772KB 2132ms
public class Yoo18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //자기보다 작은 것들을 출력
        String[] numbers = br.readLine().split(" ");
        int[] targets = new int[n];

        //String[] -> int[]
        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(numbers[i]);
        }

        int[] targetsClone = targets.clone();
        Arrays.sort(targetsClone);

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < targetsClone.length; i++) {
            if (!map.containsKey(targetsClone[i])) {
                map.put(targetsClone[i], count++);
            }
        }
        //targets의 원소들을 key 값으로 가지는 value 출력
        StringBuilder sb = new StringBuilder(); //시간초과
        for (int i = 0; i < targets.length; i++) {
            sb.append(map.get(targets[i])).append(" ");
        }
        System.out.println(sb);
    }
}
