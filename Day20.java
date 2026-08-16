// A. Elephant
// time limit per test1 second
// memory limit per test256 megabytes
// An elephant decided to visit his friend. It turned out that the elephant's house is located at point 0 and his friend's house is located at point x(x > 0) of the coordinate line. In one step the elephant can move 1, 2, 3, 4 or 5 positions forward. Determine, what is the minimum number of steps he need to make in order to get to his friend's house.

// Input
// The first line of the input contains an integer x (1 ≤ x ≤ 1 000 000) — The coordinate of the friend's house.

// Output
// Print the minimum number of steps that elephant needs to make to get from point 0 to point x.

// Examples
// InputCopy
// 5
// OutputCopy
// 1
// InputCopy
// 12
// OutputCopy
// 3
// Note
// In the first sample the elephant needs to make one step of length 5 to reach the point x.

// In the second sample the elephant can get to point x if he moves by 3, 5 and 4. There are other ways to get the optimal answer but the elephant cannot reach x in less than three moves.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the target coordinate x
        int x = Integer.parseInt(br.readLine().trim());
        
        // Calculate the minimum steps using integer ceiling division
        int steps = (x + 4) / 5;
        
        // Output the result
        System.out.println(steps);
    }
}