/*A. Football
time limit per test2 seconds
memory limit per test256 megabytes
Petya loves football very much. One day, as he was watching a football match, he was writing the players' current positions on a piece of paper. To simplify the situation he depicted it as a string consisting of zeroes and ones. A zero corresponds to players of one team; a one corresponds to players of another team. If there are at least 7 players of some team standing one after another, then the situation is considered dangerous. For example, the situation 00100110111111101 is dangerous and 11110111011101 is not. You are given the current situation. Determine whether it is dangerous or not.

Input
The first input line contains a non-empty string consisting of characters "0" and "1", which represents players. The length of the string does not exceed 100 characters. There's at least one player from each team present on the field.

Output
Print "YES" if the situation is dangerous. Otherwise, print "NO".

Examples
InputCopy
001001
OutputCopy
NO
InputCopy
1000000001
OutputCopy
YES */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the string of players
        String players = br.readLine();
        
        // If the total number of players is less than 7, it's impossible to be dangerous
        if (players.length() < 7) {
            System.out.println("NO");
            return;
        }
        
        int consecutiveCount = 1;
        char previousPlayer = players.charAt(0);
        
        // Iterate through the string starting from the second player
        for (int i = 1; i < players.length(); i++) {
            char currentPlayer = players.charAt(i);
            
            // Check if the current player is on the same team as the previous one
            if (currentPlayer == previousPlayer) {
                consecutiveCount++;
                
                // If we reach 7 in a row, the situation is dangerous
                if (consecutiveCount == 7) {
                    System.out.println("YES");
                    return; // Exit the program immediately
                }
            } else {
                // The sequence is broken, reset the counter
                consecutiveCount = 1;
                previousPlayer = currentPlayer;
            }
        }
        
        // If the loop finishes without finding 7 in a row, it is not dangerous
        System.out.println("NO");
    }
}