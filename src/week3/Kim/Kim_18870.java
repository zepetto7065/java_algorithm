package week3.Kim;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kim_18870 {
    //좌표압축 : https://www.acmicpc.net/problem/18870 -	358808kb	2200ms  X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] count = new long[N];
        String[] line = br.readLine().split(" ");
        for(int i=0;i<line.length;i++){
            arr[i] = Integer.parseInt(line[i]);
            count[i] = arr[i];
        }
        Arrays.sort(count);
        Map<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(map.get(count[i])==null) map.put(count[i],cnt++);
        }
        for(int i=0; i<N; i++) {
            bw.append(map.get(arr[i])+" ");
        }
        bw.close();
    }
}
