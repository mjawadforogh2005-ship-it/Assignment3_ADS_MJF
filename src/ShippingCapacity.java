import java.util.Scanner;

public class ShippingCapacity {

    static int findMaxWeight(int[] weights) {
        int maxWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
        }
        return maxWeight;
    }

    static int sumAllWeights(int[] weights) {
        int total = 0;
        for (int weight : weights) {
            total += weight;
        }
        return total;
    }

    static boolean canShipWithinDays(int[] weights, int allowedDays, int truckCapacity) {
        int daysUsed = 1;
        int currentLoad = 0;
        for (int weight : weights) {
            if (currentLoad + weight > truckCapacity) {
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return daysUsed <= allowedDays;
    }

    static int findMinimumCapacity(int[] weights, int allowedDays) {
        int lowerBound = findMaxWeight(weights);
        int upperBound = sumAllWeights(weights);

        while (lowerBound < upperBound) {
            int midCapacity = (lowerBound + upperBound) / 2;
            if (canShipWithinDays(weights, allowedDays, midCapacity)) {
                upperBound = midCapacity;
            } else {
                lowerBound = midCapacity + 1;
            }
        }
        return lowerBound;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of packages: ");
        int packageCount = scanner.nextInt();

        int[] weights = new int[packageCount];
        System.out.println("Enter each package weight:");
        for (int i = 0; i < packageCount; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter number of days: ");
        int allowedDays = scanner.nextInt();

        int minimumCapacity = findMinimumCapacity(weights, allowedDays);
        System.out.println("Minimum truck capacity: " + minimumCapacity);
    }
}