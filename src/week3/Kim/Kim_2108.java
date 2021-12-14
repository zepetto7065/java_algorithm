package week3.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kim_2108 {
    private static int[] arr;
    private static int N;
    //통계학 : https://www.acmicpc.net/problem/2108 -  48760kb	556ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int total = 0;
        int maxval=-10000;
        int minval=10000;
        int[] count = new int[8001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total+=arr[i];
            count[arr[i]+4000]++;
            if(maxval<arr[i]) maxval=arr[i];
            if(minval>arr[i]) minval=arr[i];
        }
        Arrays.sort(arr);
        //mergeSort(0, N - 1);

        //산술평균
        System.out.println((int)Math.round((double) total/N));
        //중앙값
        System.out.println(arr[N/2]);
        //최빈값
        int max = 0;
        int mode = 0;
        for(int i=minval+4000;i<=maxval+4000;i++){
            if(max <= count[i]){
                max=count[i];
            }
        }
        int cnt = 0;
        for(int i=0;i<=8000;i++){
            if (cnt>1) break;
            if(count[i]==max) {
                mode = i;
                cnt++;
            }
        }
        System.out.println(mode-4000);
        //최댓값-최솟값
        System.out.println(maxval-minval);
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {
        int i, j, k, l;
        i = start;
        j = mid + 1;
        k = start;
        int[] temp = new int[N];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= end)
            temp[k++] = arr[j++];

        for (l = start; l < k; l++) {
            arr[l] = temp[l];
        }
    }
}
