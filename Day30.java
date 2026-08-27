import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String tStr = fs.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            long[] b = new long[n];
            Map<Long, Integer> countMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();
                countMap.put(b[i], countMap.getOrDefault(b[i], 0) + 1);
            }

            // The minimum shadow must be 0 because the smallest element has no strictly smaller elements
            if (!countMap.containsKey(0L)) {
                out.append("-1\n");
                continue;
            }

            // Extract and sort distinct shadow values
            Long[] u = countMap.keySet().toArray(new Long[0]);
            Arrays.sort(u);

            int k = u.length;
            long[] v = new long[k];
            boolean possible = true;

            // Compute the assigned value for each shadow group
            for (int i = 0; i < k - 1; i++) {
                long diff = u[i + 1] - u[i];
                int cnt = countMap.get(u[i]);

                if (diff <= 0 || diff % cnt != 0) {
                    possible = false;
                    break;
                }

                v[i] = diff / cnt;

                // Elements must be strictly increasing across tiers
                if (i > 0 && v[i] <= v[i - 1]) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                out.append("-1\n");
                continue;
            }

            // Lexicographically minimize the largest tier
            if (k == 1) {
                v[0] = 1;
            } else {
                v[k - 1] = v[k - 2] + 1;
            }

            // Map each shadow value to its reconstructed array value
            Map<Long, Long> valMap = new HashMap<>();
            for (int i = 0; i < k; i++) {
                valMap.put(u[i], v[i]);
            }

            for (int i = 0; i < n; i++) {
                out.append(valMap.get(b[i])).append(i == n - 1 ? "" : " ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}