package week3.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Kim_1181 {
    //단어정렬 : https://www.acmicpc.net/problem/1181 - 22764kb	724ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else {
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });

        for(int i=0;i<N;i++) {
            if(i>0 && arr[i].equals(arr[i-1])) continue;
            System.out.println(arr[i]);
        }
    }
}
