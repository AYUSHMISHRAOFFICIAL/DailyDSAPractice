// A. Insomnia cure
// time limit per test2 seconds
// memory limit per test256 megabytes
// «One dragon. Two dragon. Three dragon», — the princess was counting. She had trouble falling asleep, and she got bored of counting lambs when she was nine.

// However, just counting dragons was boring as well, so she entertained herself at best she could. Tonight she imagined that all dragons were here to steal her, and she was fighting them off. Every k-th dragon got punched in the face with a frying pan. Every l-th dragon got his tail shut into the balcony door. Every m-th dragon got his paws trampled with sharp heels. Finally, she threatened every n-th dragon to call her mom, and he withdrew in panic.

// How many imaginary dragons suffered moral or physical damage tonight, if the princess counted a total of d dragons?

// Input
// Input data contains integer numbers k, l, m, n and d, each number in a separate line (1 ≤ k, l, m, n ≤ 10, 1 ≤ d ≤ 105).

// Output
// Output the number of damaged dragons.

// Examples
// InputCopy
// 1
// 2
// 3
// 4
// 12
// OutputCopy
// 12
// InputCopy
// 2
// 3
// 4
// 5
// 24
// OutputCopy
// 17
// Note
// In the first case every first dragon got punched with a frying pan. Some of the dragons suffered from other reasons as well, but the pan alone would be enough.

// In the second case dragons 1, 7, 11, 13, 17, 19 and 23 escaped unharmed.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the input variables
        int k = Integer.parseInt(br.readLine().trim());
        int l = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int d = Integer.parseInt(br.readLine().trim());
        
        // O(1) early exit optimization: 
        // If any divisor is 1, every dragon is damaged.
        if (k == 1 || l == 1 || m == 1 || n == 1) {
            System.out.println(d);
            return;
        }
        
        int damagedDragons = 0;
        
        // Iterate through all the dragons from 1 to d
        for (int i = 1; i <= d; i++) {
            // Check if the current dragon gets hit by at least one method
            if (i % k == 0 || i % l == 0 || i % m == 0 || i % n == 0) {
                damagedDragons++;
            }
        }
        
        // Output the final tally of damaged dragons
        System.out.println(damagedDragons);
    }
}