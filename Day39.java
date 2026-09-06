import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long totalSum = 0;
            
            // Frequency array based on max constraint (a_i <= 1000)
            int[] count = new int[1005]; 
            int maxFreq = 0;
            long maxFreqValue = 0;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                totalSum += val;
                count[val]++;
                
                // Track the majority element and its frequency
                if (count[val] > maxFreq) {
                    maxFreq = count[val];
                    maxFreqValue = val;
                }
            }
            
            // If we can separate the majority element sufficiently
            if (2 * maxFreq <= n + 2) {
                System.out.println(totalSum);
            } else {
                // We are forced to drop some of the majority cards.
                // Number of majority cards we CAN play is (n - maxFreq) + 2.
                // The formula below subtracts the unused majority cards from the total sum.
                long maxDamage = totalSum - maxFreqValue * (2 * maxFreq - n - 2);
                System.out.println(maxDamage);
            }
        }
        sc.close();
    }
}
