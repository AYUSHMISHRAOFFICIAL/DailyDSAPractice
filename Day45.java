import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            // freq[i] stores the number of carrots of exactly length i
            int[] freq = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                freq[a]++;
            }

            // suff[i] stores the number of carrots of length >= i
            int[] suff = new int[m + 2];
            for (int i = m; i >= 1; i--) {
                suff[i] = freq[i] + suff[i + 1];
            }

            int maxCarrots = 0;
            
            // Check all possible target lengths L
            for (int L = 1; L <= m; L++) {
                int current = suff[L]; // Every carrot >= L contributes at least 1
                
                // Carrots of exactly 2*L contribute an extra 1 (since they split into L and L)
                if (2 * L <= m) {
                    current += freq[2 * L];
                }
                
                if (current > maxCarrots) {
                    maxCarrots = current;
                }
            }
            out.println(maxCarrots);
        }
        out.flush();
    }

    // Fast I/O Template
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
}
