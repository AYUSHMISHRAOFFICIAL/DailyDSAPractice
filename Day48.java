import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean hasThreeOrMore = false;
            int countOfTwosOrMore = 0;

            for (int i = 0; i < k; i++) {
                int count = Integer.parseInt(st.nextToken());
                
                if (count >= 3) {
                    hasThreeOrMore = true;
                }
                if (count >= 2) {
                    countOfTwosOrMore++;
                }
            }

            // Check if we satisfy either condition
            if (hasThreeOrMore || countOfTwosOrMore >= 2) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        // Print all results at once for efficiency
        System.out.print(sb.toString());
    }
}
