package week3.Yun;

import java.util.*;

public class Yun_1181 {  //64312KB	3380ms
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWord = scanner.nextInt();
        scanner.nextLine();

        List<String> words = new ArrayList<>();
        setWords(scanner, numberOfWord, words);

        sorting(words);
        printWords(words);

    }

    private static void sorting(List<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });
    }

    private static void printWords(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }

    private static void setWords(Scanner scanner, int numberOfWord, List<String> words) {
        for (int i = 0; i < numberOfWord; i++) {
            String newWord = scanner.nextLine();
            if (!words.contains(newWord)) {
                words.add(newWord);
            }
        }
    }
}

//64312KB	3380ms