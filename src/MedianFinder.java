//Task 3
import java.util.Arrays;
import java.util.Scanner;

public class MedianFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int mid = n / 2;

        if (n % 2 != 0) {
            System.out.println(arr[mid]);
        } else {
            System.out.println((arr[mid - 1] + arr[mid]) / 2.0);
        }
    }
}