import java.io.*;
import java.util.*;

public class Main {
    
    // FastScanner template for competitive programming efficiency 
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
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            // If k == n - 1, we only have 1 block (all same characters). 
            // This is impossible to balance for n >= 2.
            if (k == n - 1) {
                out.println("-1");
                continue;
            }

            int b = n - k; // Total alternating blocks we need
            
            // Assign optimal counts to satisfy the difference <= 1 rule
            int cnt0 = (n + 1) / 2;
            int cnt1 = n / 2;
            int[] cnt = {cnt0, cnt1};
            char[] chars = {'0', '1'};

            StringBuilder sb = new StringBuilder(n);
            int cur = 0; // Start with '0'

            // Populate the first b - 2 blocks with exactly 1 character each
            for (int i = 0; i < b - 2; i++) {
                sb.append(chars[cur]);
                cnt[cur]--;
                cur = 1 - cur;
            }

            // Dump all remaining characters into the second-to-last block
            int countCur = cnt[cur];
            for (int i = 0; i < countCur; i++) {
                sb.append(chars[cur]);
            }
            cur = 1 - cur;

            // Dump all remaining characters into the final block
            int countNext = cnt[cur];
            for (int i = 0; i < countNext; i++) {
                sb.append(chars[cur]);
            }

            out.println(sb.toString());
        }
        
        // Ensure the buffer flushes to standard output
        out.flush(); 
    }
}
