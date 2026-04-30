//Task 1
import java.util.Scanner;

public class AnagramChecker {

    static void bubbleSort(char[] letters) {
        int length = letters.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (letters[j] > letters[j + 1]) {
                    char temp = letters[j];
                    letters[j] = letters[j + 1];
                    letters[j + 1] = temp;
                }
            }
        }
    }

    static boolean compareChars(char[] first, char[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String firstWord = scanner.next().toLowerCase();
        System.out.print("Enter second word: ");
        String secondWord = scanner.next().toLowerCase();

        char[] firstLetters = firstWord.toCharArray();
        char[] secondLetters = secondWord.toCharArray();

        bubbleSort(firstLetters);
        bubbleSort(secondLetters);

        if (compareChars(firstLetters, secondLetters)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}