package week3.Yoo;

public class YooSort {

    private static int[] numbers;
    private static int[] temps;

    public static void main(String[] args) {

        //merge sort
        numbers = new int[] { 2, 1, 7, 6, 3, 5 };
        //        temps = new int[numbers.length]; //추가 저장 공간
        mergeSort(0, numbers.length - 1);

        //                quickSort(0, numbers.length - 1);

        for (int num : numbers) {
            System.out.print(num + " ");
        }

    }

    private static void quickSort(int start, int end) {
        int num = partition(start, end);
        if (start < num - 1) {
            quickSort(start, num - 1);
        }
        if (num < end) {
            quickSort(num, end);
        }
    }

    private static int partition(int start, int end) {
        int pivot = numbers[(start + end) / 2]; //중간의 수를 피봇으로 선정
        while (start <= end) {
            while (numbers[start] < pivot)
                start++;
            while (numbers[end] > pivot)
                end--;
            if (start <= end) { //조건에 안맞다면 switch
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int a = start;
            int b = mid + 1;
            int idx = a;

            while (a <= mid || b <= end) {
                if (b > end || (a <= mid && numbers[a] < numbers[b])) {
                    temps[idx++] = numbers[a++];
                } else {
                    temps[idx++] = numbers[b++];
                }
            }

            for (int i = start; i <= end; i++) {
                numbers[i] = temps[i];
            }
        }

    }

    private static void BubbleSort() {
        int[] numbers = new int[] { 2, 1, 7, 6, 3, 5 };

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void insertionSort() {
        int[] numbers = new int[] { 2, 1, 7, 6, 3, 5 };

        for (int i = 1; i < numbers.length; i++) {
            int temp;
            for (int j = i; j > 0; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void selectSort() {
        int[] numbers = new int[] { 2, 1, 7, 6, 3, 5 };

        for (int i = 0; i < numbers.length - 1; i++) {
            int minIdx = i;
            int temp;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }

            temp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = temp;
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }

    }

}
