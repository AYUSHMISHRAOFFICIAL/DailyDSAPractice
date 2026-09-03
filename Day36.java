import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int rounds = 0;
            
            // Continue the game as long as all three have strictly different token amounts
            while (a != b && b != c && a != c) {
                // Find who has the strictly most tokens and who has the strictly fewest
                if (a > b && a > c) { // a has the most
                    a--;
                    if (b < c) b++; else c++;
                } else if (b > a && b > c) { // b has the most
                    b--;
                    if (a < c) a++; else c++;
                } else { // c has the most
                    c--;
                    if (a < b) a++; else b++;
                }
                rounds++;
            }
            
            out.append(rounds).append("\n");
        }
        
        // Print all results at once
        System.out.print(out);
    }
}