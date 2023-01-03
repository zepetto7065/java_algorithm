package week12.Han;

import java.io.*;
import java.util.*;

public class Han_블랙잭 {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner sc = new Scanner(new FileInputStream("src/acmicpc/input.txt"));
		// Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int z = j+1; z < N; z++) {
					int sum= arr[i]+arr[j]+arr[z];
					//System.out.println(arr[i]+" + "+arr[j]+" + "+arr[z]+" = "+sum);
					if(sum <= M) {
						count=Math.max(sum,count);
					}
				}
				
			}
		}
		System.out.println(count);
		

	}
}
