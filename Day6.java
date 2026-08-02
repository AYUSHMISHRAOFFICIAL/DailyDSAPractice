// A. Beautiful Matrix

// time limit per test2 seconds

// memory limit per test256 megabytes

// You've got a 5 × 5 matrix, consisting of 24 zeroes and a single number one. Let's index the matrix rows by numbers from 1 to 5 from top to bottom, let's index the matrix columns by numbers from 1 to 5 from left to right. In one move, you are allowed to apply one of the two following transformations to the matrix:

// Swap two neighboring matrix rows, that is, rows with indexes i and i + 1 for some integer i (1 ≤ i < 5).

// Swap two neighboring matrix columns, that is, columns with indexes j and j + 1 for some integer j (1 ≤ j < 5).

// You think that a matrix looks beautiful, if the single number one of the matrix is located in its middle (in the cell that is on the intersection of the third row and the third column). Count the minimum number of moves needed to make the matrix beautiful.

// Input



// The input consists of five lines, each line contains five integers: the j-th integer in the i-th line of the input represents the element of the matrix that is located on the intersection of the i-th row and the j-th column. It is guaranteed that the matrix consists of 24 zeroes and a single number one.

// Output



// Print a single integer — the minimum number of moves needed to make the matrix beautiful.

// Examples

// Input

// 0 0 0 0 0

// 0 0 0 0 1

// 0 0 0 0 0

// 0 0 0 0 0

// 0 0 0 0 0

// Output

// 3

// Input

// 0 0 0 0 0

// 0 0 0 0 0

// 0 1 0 0 0

// 0 0 0 0 0

// 0 0 0 0 0

// Output

// 1


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for highly efficient I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Loop through the 5 rows (1-indexed)
        for (int r = 1; r <= 5; r++) {
            // Read the current row and tokenize it by spaces
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // Loop through the 5 columns (1-indexed)
            for (int c = 1; c <= 5; c++) {
                // If the current token is the number "1"
                if (st.nextToken().equals("1")) {
                    // Calculate Manhattan distance directly
                    int moves = Math.abs(r - 3) + Math.abs(c - 3);
                    
                    // Print the optimal number of moves
                    System.out.println(moves);
                    
                    // Exit the program immediately as the answer is found
                    return; 
                }
            }
        }
    }
}