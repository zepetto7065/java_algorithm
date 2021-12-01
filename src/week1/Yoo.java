package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Yoo {

    //설탕배달 문제
    public void problem2839() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        while (true) {
            if (n % 5 == 0) {
                result += n / 5;
                break;
            } else {
                n -= 3;
                result++;
            }
            if (n < 0) {
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }

    //ATM
    //https://www.acmicpc.net/problem/11399
    public void problem11399() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] times = br.readLine().split(" ");
        List<Integer> pI = new ArrayList<>();
        int result = 0;

        //걸리는 시간 받기
        for (int i = 0; i < n; i++) {
            pI.add(Integer.parseInt(times[i]));
        }

        //오름차순 정렬
        Collections.sort(pI); //1 2 3 3 4

        //각 순번의 걸린 시간 구하기
        int time = 0;
        for (int i = 0; i < pI.size(); i++) {
            time = pI.get(0);
            for (int j = 1; j < i + 1; j++) {
                time += pI.get(j);
            }

            result += time;
        }

        System.out.println(result);
    }

    //동전 0
    public void problem11047() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        int result = 0;

        //동전 단위 setting
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        //큰 동전의 단위부터 거꾸로 조사
        for (int i = coins.length - 1; i >= 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }
        System.out.println(result);
    }

    //동전 0 BufferedReader 이용
    public void problem11047BufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //한줄에 띄어쓰기(" ")로 입력받은 n과 k를 위해

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        int result = 0;

        //동전 단위 setting
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        //큰 동전의 단위부터 거꾸로 조사
        for (int i = coins.length - 1; i >= 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }
        System.out.println(result);
    }

    public void problem1026() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            result += A[i] * B[n - 1 - i];
        }
        System.out.println(result);
    }

    public void solution1() {
        int answer = 2631;
        List<String> nums = new ArrayList<>();
        String min = "";
        String max = "";

        //하나씩 잘라서 배열로 만든다
        while (answer > 0) {
            nums.add(Integer.toString(answer % 10));
            answer /= 10;
        }
        //정렬하여 가장 작은 수를 만든다
        Collections.sort(nums);
        for (String num : nums) {
            min += num;
        }

        //거꾸로 정렬하여 가장 큰 수를 만든다.
        Collections.reverse(nums);
        for (String num : nums) {
            max += num;
        }

        System.out.println(Integer.parseInt(min) + Integer.parseInt(max));
    }

    public void solution2() {
        String p = "PM 01:00:00";
        int n = 15000; //2만 이하

        String answer = "";

        //AM인지 PM인지 시분초 분리
        String sun = p.substring(0, 2); //PM
        String time = p.substring(3, p.length()); //01:00:00
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        //24시간 단위로 변환
        if ("PM".equals(sun)) {
            hour += 12;
        }

        //n초 후 12시간 단위 시간 구한다.
        hour += (n / 3600);
        n %= 3600;
        minute += (n / 60);
        n %= 60;
        second += n;

        //분과 초가 60이 넘으면 시 , 분을 올려준다.
        if (second > 59) {
            minute += 1;
            second -= 60;
        }
        if (minute > 59) {
            hour += 1;
            minute -= 60;
        }
        if (hour > 23 && hour < 48) {
            hour -= 24;
        } else if (hour > 48 && hour < 72) {
            hour -= 48;
        } else if (hour >= 72) {
            hour -= 72;
        }

        String hourStr = Integer.toString(hour);
        String minuteStr = Integer.toString(minute);
        String secondStr = Integer.toString(second);

        //두자리가 아니라면 0을 추가한다.
        if (hourStr.length() == 1) {
            hourStr = "0" + hourStr;
        }
        if (minuteStr.length() == 1) {
            minuteStr = "0" + minuteStr;
        }
        if (secondStr.length() == 1) {
            secondStr = "0" + secondStr;
        }

        System.out.println(hourStr + ":" + minuteStr + ":" + secondStr);
    }

    public void solution3() {
        int[] arr = new int[] { 4, 2, 3, 45, 1 };
        Map<Integer, Integer> targets = new HashMap<>();
        int firstIdx = 0;
        int secondIdx = 0;
        int answer = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!targets.containsKey(arr[i])) {
                targets.put(arr[i], i);
            } else {
                firstIdx = targets.get(arr[i]);
                secondIdx = i;
                answer = secondIdx - firstIdx;
                break;
            }
            count++;
        }

        if (count == arr.length) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public void solution_emart() {
        //        [조건 1] 현재 데이터가 처음이나 마지막 데이터가 아닙니다.
        //        [조건 2] 현재 데이터와 다음 데이터와의 차이(절댓값)가 d 이하입니다.
        //        [조건 3] 이전 데이터까지 연속으로 삭제된 데이터가 k개 이하입니다.

        int[] answer = { 13, 15, 14, 17, 18, 16, 16 };
        int d = 2;
        int k = 2;
        int count = 0; //연속으로 삭제
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            //조건1
            if (i == 0 || i == answer.length - 1) {
                answerList.add(answer[i]);
                continue;
            }

            int d2 = Math.abs(d);
            int d3 = Math.abs(answer[i + 1] - answer[i]);
            //조건2
            if (d3 <= d2 && count <= k) { //삭제되는 경우
                count++;
            } else {
                answerList.add(answer[i]);
                count = 0;
            }
        }

        final int[] results = answerList.stream().mapToInt(Integer::intValue).toArray();
    }

}
