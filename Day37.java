import java.io.*;
import java.util.*;

public class Main {
    // Fast I/O scanner for competitive programming
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        String tStr = in.next();
        if (tStr == null) return;
        
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            // The only card that could win against all is (n + 1).
            // It wins if and only if (n + 1) is a prime number.
            if (isPrime(n + 1)) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }
        
        // Output all results efficiently in one go
        System.out.print(out);
    }

    // O(sqrt(N)) Prime Check
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        // Loop up to the square root of num
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}