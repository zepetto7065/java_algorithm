package week12.Han;

import java.io.*;
import java.util.*;

public class Han_단어뒤집기2 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/acmicpc/input.txt"));
		// Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		String answer = "";
		int count = 0;
		List<String> taskList = new LinkedList<String>();
		// Collections.reverse(taskList);
		boolean isTag = false;
		boolean isSpace = false;
		boolean isEnd = false;
		int i = 0;
		String tmp = "";

		while (N.length() > i) {

			if (N.charAt(i) == '<') {

				isTag = true;
				tmp += N.charAt(i);

			} else if (N.charAt(i) == '>') {
				isTag = false;
				isEnd = true;
				tmp += N.charAt(i);

			} else if (isTag) {
				tmp += N.charAt(i);

			} else {

				if (i + 1 == N.length()) {
					tmp += N.charAt(i);
					isEnd = true;

				} else if (N.charAt(i) == ' ') {
					isEnd = true;
					isSpace = true;
				} else if (N.charAt(i + 1) == '<') {
					tmp += N.charAt(i);
					isEnd = true;
				}

				if (!isEnd) {
					tmp += N.charAt(i);
				} else {
					StringBuffer sb = new StringBuffer(tmp);
					String reversedStr = sb.reverse().toString();
					tmp = reversedStr;

				}

			}
			System.out.println(tmp);
			if (isEnd) {
				answer += tmp;
				tmp = "";
				if (isSpace) {
					answer += " ";
					isSpace = false;
				}
				isEnd = false;
			}
			i++;

		}
		System.out.println(answer);

	}
}
