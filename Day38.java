import java.io.*;
import java.util.*;

public class Main {
    
    // FastReader class for optimal I/O performance in competitive programming
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
        FastReader in = new FastReader();
        String tStr = in.next();
        if (tStr == null) return;
        
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            // Step 1: Find the base compressed length (L)
            int L = 1;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    L++;
                }
            }

            // Step 2: Find the best character to delete to maximize the length reduction
            int maxDelta = 0;
            for (int i = 1; i < n - 1; i++) {
                // Cost is 1 if characters differ (adds to compressed length), 0 if same
                int costLeft = s.charAt(i - 1) != s.charAt(i) ? 1 : 0;
                int costRight = s.charAt(i) != s.charAt(i + 1) ? 1 : 0;
                int costCross = s.charAt(i - 1) != s.charAt(i + 1) ? 1 : 0;

                // Length reduced by losing the two adjacent connections, minus the new cross connection
                int delta = costLeft + costRight - costCross;
                
                if (delta > maxDelta) {
                    maxDelta = delta;
                }
                
                // 2 is the maximum possible reduction (e.g., in "aba", removing 'b' leaves "aa").
                // If we find it, we can't do any better, so break early to save time.
                if (maxDelta == 2) {
                    break; 
                }
            }

            // Output the minimum possible length
            out.append(L - maxDelta).append("\n");
        }
        
        // Print all results efficiently
        System.out.print(out);
    }
}
