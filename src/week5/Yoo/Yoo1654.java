package week5.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15328KB 136ms
//https://st-lab.tistory.com/269
public class Yoo1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        //특정 개수에 대하여 특정 길이의 최대값 (upper)
        while (min < max) {
            mid = (max + min) / 2;
            long count = 0;

            for(int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if(count < n){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}
