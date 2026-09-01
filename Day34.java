import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[3];
        
        while (t-- > 0) {
            while (!st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            arr[0] = Long.parseLong(st.nextToken());
            arr[1] = Long.parseLong(st.nextToken());
            arr[2] = Long.parseLong(st.nextToken());
            
            Arrays.sort(arr);
            
            // arr[0] = x, arr[1] = y, arr[2] = z where x <= y <= z
            // Initial range: z - x
            // Range after replacing z with (x + y): (x + y) - x = y
            long ans = Math.min(arr[2] - arr[0], arr[1]);
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}