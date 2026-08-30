import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                String next = br.readLine();
                if (next == null) break;
                st = new StringTokenizer(next);
            }
            if (st == null || !st.hasMoreTokens()) break;

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] available = new boolean[26];

            for (int i = 0; i < n; i++) {
                String word = br.readLine().trim();
                available[Character.toUpperCase(word.charAt(0)) - 'A'] = true;
            }

            String[] abbreviations = new String[m];
            boolean[] formed = new boolean[m];
            for (int i = 0; i < m; i++) {
                abbreviations[i] = br.readLine().trim();
            }

            int formedCount = 0;
            boolean updated = true;

            while (updated && formedCount < m) {
                updated = false;
                for (int i = 0; i < m; i++) {
                    if (!formed[i]) {
                        boolean canForm = true;
                        for (int j = 0; j < abbreviations[i].length(); j++) {
                            char ch = abbreviations[i].charAt(j);
                            if (!available[ch - 'A']) {
                                canForm = false;
                                break;
                            }
                        }

                        if (canForm) {
                            formed[i] = true;
                            formedCount++;
                            available[abbreviations[i].charAt(0) - 'A'] = true;
                            updated = true;
                        }
                    }
                }
            }

            if (formedCount == m) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}