import java.io.*;
import java.util.*;

public class Main {
    
    // FastScanner class for optimal I/O speeds
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
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
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            
            int aEven1 = 0, aOdd1 = 0;
            int bEven1 = 0, bOdd1 = 0;
            
            // Count '1's at even and odd indices for both strings
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    if (i % 2 == 0) aEven1++;
                    else aOdd1++;
                }
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0) bEven1++;
                    else bOdd1++;
                }
            }
            
            // If the counts match, they can be transformed
            if (aEven1 == bEven1 && aOdd1 == bOdd1) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        // Print everything at once for efficiency
        System.out.print(sb);
    }
}
