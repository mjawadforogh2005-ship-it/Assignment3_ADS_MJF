//Task 1
import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next().toLowerCase();
        String b = sc.next().toLowerCase();

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        if (Arrays.equals(arrA, arrB)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}