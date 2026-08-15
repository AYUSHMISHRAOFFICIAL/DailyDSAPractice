import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the single line containing k, n, and w
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // Parse inputs as longs to prevent any possible overflow during multiplication
        long k = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        
        // Calculate the total cost using the arithmetic progression sum formula
        long totalCost = k * (w * (w + 1) / 2);
        
        // Calculate how much needs to be borrowed
        long borrowed = totalCost - n;
        
        // If the borrowed amount is less than 0, he doesn't need to borrow anything
        if (borrowed < 0) {
            System.out.println(0);
        } else {
            System.out.println(borrowed);
        }
    }
}