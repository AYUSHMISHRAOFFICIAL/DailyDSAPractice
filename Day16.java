// A. New Year Candles
// time limit per test1 second
// memory limit per test256 megabytes
// Vasily the Programmer loves romance, so this year he decided to illuminate his room with candles.

// Vasily has a candles.When Vasily lights up a new candle, it first burns for an hour and then it goes out. Vasily is smart, so he can make b went out candles into a new candle. As a result, this new candle can be used like any other new candle.

// Now Vasily wonders: for how many hours can his candles light up the room if he acts optimally well? Help him find this number.

// Input
// The single line contains two integers, a and b (1 ≤ a ≤ 1000; 2 ≤ b ≤ 1000).

// Output
// Print a single integer — the number of hours Vasily can light up the room for.

// Examples
// InputCopy
// 4 2
// OutputCopy
// 7
// InputCopy
// 6 3
// OutputCopy
// 8
// Note
// Consider the first sample. For the first four hours Vasily lights up new candles, then he uses four burned out candles to make two new ones and lights them up. When these candles go out (stop burning), Vasily can make another candle. Overall, Vasily can light up the room for 7 hours.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for highly efficient I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the two integers a and b
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int totalHours = 0;
        int currentStubs = 0;
        
        // Continue burning as long as we have whole candles left
        while (a > 0) {
            // Burn the current candles, adding to the total time
            totalHours += a;
            
            // Collect the stubs from the candles we just burned
            currentStubs += a;
            
            // Forge new candles from the accumulated stubs
            a = currentStubs / b;
            
            // Save the remaining stubs that weren't enough to form a whole candle
            currentStubs = currentStubs % b;
        }
        
        // Output the final number of hours
        System.out.println(totalHours);
    }
}