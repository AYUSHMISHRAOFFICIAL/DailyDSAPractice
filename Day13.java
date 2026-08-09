// A. Magnets
// time limit per test1 second
// memory limit per test256 megabytes
// Mad scientist Mike entertains himself by arranging rows of dominoes. He doesn't need dominoes, though: he uses rectangular magnets instead. Each magnet has two poles, positive (a "plus") and negative (a "minus"). If two magnets are put together at a close distance, then the like poles will repel each other and the opposite poles will attract each other.

// Mike starts by laying one magnet horizontally on the table. During each following step Mike adds one more magnet horizontally to the right end of the row. Depending on how Mike puts the magnet on the table, it is either attracted to the previous one (forming a group of multiple magnets linked together) or repelled by it (then Mike lays this magnet at some distance to the right from the previous one). We assume that a sole magnet not linked to others forms a group of its own.


// Mike arranged multiple magnets in a row. Determine the number of groups that the magnets formed.

// Input
// The first line of the input contains an integer n (1 ≤ n ≤ 100000) — the number of magnets. Then n lines follow. The i-th line (1 ≤ i ≤ n) contains either characters "01", if Mike put the i-th magnet in the "plus-minus" position, or characters "10", if Mike put the magnet in the "minus-plus" position.

// Output
// On the single line of the output print the number of groups of magnets.

// Examples
// InputCopy
// 6
// 10
// 10
// 10
// 01
// 10
// 10
// OutputCopy
// 3
// InputCopy
// 4
// 01
// 01
// 10
// 10
// OutputCopy
// 2
// Note
// The first testcase corresponds to the figure. The testcase has three groups consisting of three, one and two magnets.

// The second testcase has two groups, each consisting of two magnets.


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the total number of magnets
        int n = Integer.parseInt(br.readLine().trim());
        
        // The first magnet always constitutes at least 1 group
        int groups = 1;
        
        // Read the first magnet to serve as our initial baseline comparison
        String prev = br.readLine();
        
        // Loop through the remaining n - 1 magnets
        for (int i = 1; i < n; i++) {
            String curr = br.readLine();
            
            // If the first character of the current magnet doesn't match the 
            // first character of the previous magnet, they repel and start a new group.
            if (curr.charAt(0) != prev.charAt(0)) {
                groups++;
            }
            
            // Update the previous magnet for the next iteration
            prev = curr;
        }
        
        // Output the final tally of groups
        System.out.println(groups);
    }
}