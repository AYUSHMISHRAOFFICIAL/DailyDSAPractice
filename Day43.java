import java.util.Scanner;

public class Main {
    
    // Function to calculate Greatest Common Divisor
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long first = 0;
            long last = 0;
            
            // Read the array elements and capture the first and last
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                if (i == 0) first = val;
                if (i == n - 1) last = val;
            }
            
            // If there's only 1 element, its GCD is itself
            if (n == 1) {
                System.out.println(first);
            } else {
                System.out.println(gcd(first, last));
            }
        }
        sc.close();
    }
}
