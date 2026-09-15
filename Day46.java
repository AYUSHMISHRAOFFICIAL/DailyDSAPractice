import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O is crucial for large inputs in Codeforces
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if (k > m) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
                
                int ones = k - 1;
                int special = m - k + 1;
                
                for (int i = 0; i < n; i++) {
                    if (i % k < ones) {
                        out.append(1).append(" ");
                    } else {
                        out.append(special).append(" ");
                    }
                }
                out.append("\n");
            }
        }
        
        // Print all outputs at once for efficiency
        System.out.print(out);
    }
}
