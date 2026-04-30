//Task 3
import java.util.Scanner;

public class MedianFinder {

    static void bubbleSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    static double calculateMedian(int[] numbers) {
        int middle = numbers.length / 2;
        if (numbers.length % 2 != 0) {
            return numbers[middle];
        } else {
            return (numbers[middle - 1] + numbers[middle]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        bubbleSort(numbers);
        double median = calculateMedian(numbers);

        if (median == (int) median) {
            System.out.println((int) median);
        } else {
            System.out.println(median);
        }
    }
}