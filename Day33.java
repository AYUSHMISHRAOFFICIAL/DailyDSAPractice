import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        StringBuilder sb = new StringBuilder();
        
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            
            int oddWays = countValid(s, 0, n);
            int evenWays = countValid(s, 1, n);
            
            sb.append(oddWays * evenWays).append("\n");
        }
        
        System.out.print(sb);
    }
    
    // Checks how many alternating binary patterns match the characters at indices: start, start + 2, ...
    private static int countValid(String s, int start, int n) {
        int validPatterns = 0;
        
        // Try starting with target = '0' and target = '1'
        for (char first = '0'; first <= '1'; first++) {
            boolean possible = true;
            char expected = first;
            
            for (int i = start; i < n; i += 2) {
                char current = s.charAt(i);
                if (current != '?' && current != expected) {
                    possible = false;
                    break;
                }
                expected = (expected == '0') ? '1' : '0';
            }
            
            if (possible) {
                validPatterns++;
            }
        }
        
        return validPatterns;
    }

    static class FastReader {
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
    }
}