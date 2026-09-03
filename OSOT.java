import java.util.Arrays;
import java.util.Scanner;

public class OptimalStorageOnTape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("enter no of tapes: ");
        int n = scanner.nextInt();
        
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("length of tape " + (i + 1) + ": ");
            lengths[i] = scanner.nextInt();
        }
        
        Arrays.sort(lengths);
        
        int totalRetrievalTime = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += lengths[i];
            totalRetrievalTime += currentSum;
        }
        
        double meanRetrievalTime = (double) totalRetrievalTime / n;
        
        System.out.println("RT: " + totalRetrievalTime);
        System.out.println("MRT: " + meanRetrievalTime);
        
        scanner.close();
    }
}

