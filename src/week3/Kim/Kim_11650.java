package week3.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kim_11650 {
    //좌표 정렬하기 : https://www.acmicpc.net/problem/11650 - 88076kb	2368ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> list = new HashMap<>();
        int key, value;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            if (list.get(key) == null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(value);
                list.put(key, temp);
            } else {
                list.get(key).add(value);
            }
            arr[i] = key;
        }
        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            ArrayList<Integer> xList = list.get(arr[i]);
            if (xList.size() > 1) {
                Collections.sort(xList);
                for (int j = 0; j < xList.size(); j++){
                    System.out.println(arr[i] + " " +xList.get(j));
                }
                i+=xList.size()-1;
            } else if (xList.size() == 1) {
                System.out.println(arr[i] + " " + xList.get(0));
            }
        }
    }
}
