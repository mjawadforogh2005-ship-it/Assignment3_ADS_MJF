// Task 4
import java.util.Scanner;
public class ShippingCapacity {

    // checks if a given capacity can ship all packages within 'days'
    static boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysUsed <= days;
    }
    static int minCapacity(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);  // must fit the heaviest package
            hi += w;               // worst case: all in one day
        }
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canShip(weights, days, mid)) {
                hi = mid;    // mid works, try smaller
            } else {
                lo = mid + 1; // mid too small, go bigger
            }
        }
        return lo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int days = sc.nextInt();

        System.out.println(minCapacity(weights, days));
    }
}