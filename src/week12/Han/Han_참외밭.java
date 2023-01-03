package week12.Han;

import java.io.*;
import java.util.*;

public class Han_참외밭 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/acmicpc/input.txt"));
		// Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int longx = 0;
		int longy = 0;
		int shortx = Integer.MAX_VALUE;
		int shorty = Integer.MAX_VALUE;

		for (int i = 0; i < 6; i++) {

			if (arr[i][0] == 3 || arr[i][0] == 4) {
				int tmp = arr[i][1];
				longy = Math.max(tmp, longy);

			} else if (arr[i][0] == 1 || arr[i][0] == 2) {
				int tmp = arr[i][1];
				longx = Math.max(tmp, longx);

			}

		}
		
		int maxSize = longy * longx;
		int minSize = 0;

		for (int i = 0; i < 6; i++) {
			if (longy == arr[i][1]) {
			
				int idx1 = (i + 1) % 6;
				int idx2 = (i - 1) % 6;
				if(idx2<0) {
					idx2=5;
				}
				
				
				shorty = Math.abs(arr[idx2][1] - arr[idx1][1]);
			}
			if (longx == arr[i][1]) {

				int idx1 = (i + 1) % 6;
				int idx2 = (i - 1) % 6;
				if(idx2<0) {
					idx2=5;
				}
				shortx = Math.abs(arr[idx2][1] - arr[idx1][1]);
			}
		}
		minSize = shorty*shortx;
		// System.out.println(maxSize);
		// System.out.println(minSize);
		// System.out.println(N);
		System.out.println(N * (maxSize - minSize));
	}
}
