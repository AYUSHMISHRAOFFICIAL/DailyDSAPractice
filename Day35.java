import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            if (line == null) break;

            int n = Integer.parseInt(st.nextToken());

            long minOdd = Long.MAX_VALUE;
            long maxEven = Long.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                long w = Long.parseLong(st.nextToken());
                if (i % 2 == 1) {
                    minOdd = Math.min(minOdd, w);
                } else {
                    maxEven = Math.max(maxEven, w);
                }
            }

            // n must be even, and there must exist an integer k strictly between maxEven and minOdd
            if (n % 2 == 0 && maxEven + 1 < minOdd) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}