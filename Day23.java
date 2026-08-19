// A. I Wanna Be the Guy
// time limit per test1 second
// memory limit per test256 megabytes
// There is a game called "I Wanna Be the Guy", consisting of n levels. Little X and his friend Little Y are addicted to the game. Each of them wants to pass the whole game.

// Little X can pass only p levels of the game. And Little Y can pass only q levels of the game. You are given the indices of levels Little X can pass and the indices of levels Little Y can pass. Will Little X and Little Y pass the whole game, if they cooperate each other?

// Input
// The first line contains a single integer n (1 ≤  n ≤ 100).

// The next line contains an integer p (0 ≤ p ≤ n) at first, then follows p distinct integers a1, a2, ..., ap (1 ≤ ai ≤ n). These integers denote the indices of levels Little X can pass. The next line contains the levels Little Y can pass in the same format. It's assumed that levels are numbered from 1 to n.

// Output
// If they can pass all the levels, print "I become the guy.". If it's impossible, print "Oh, my keyboard!" (without the quotes).

// Examples
// InputCopy
// 4
// 3 1 2 3
// 2 2 4
// OutputCopy
// I become the guy.
// InputCopy
// 4
// 3 1 2 3
// 2 2 3
// OutputCopy
// Oh, my keyboard!
// Note
// In the first sample, Little X can pass levels [1 2 3], and Little Y can pass level [2 4], so they can pass all the levels both.

// In the second sample, no one can pass level 4.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the total number of levels
        int n = Integer.parseInt(br.readLine().trim());
        
        // Boolean array to track passed levels (1-indexed for direct mapping)
        boolean[] passed = new boolean[n + 1];
        int uniqueCount = 0;
        
        // --- Process Little X ---
        StringTokenizer stX = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stX.nextToken()); // Number of levels X can pass
        
        for (int i = 0; i < p; i++) {
            int level = Integer.parseInt(stX.nextToken());
            // If this level hasn't been passed yet, mark it and increment count
            if (!passed[level]) {
                passed[level] = true;
                uniqueCount++;
            }
        }
        
        // --- Process Little Y ---
        StringTokenizer stY = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(stY.nextToken()); // Number of levels Y can pass
        
        for (int i = 0; i < q; i++) {
            int level = Integer.parseInt(stY.nextToken());
            // If this level hasn't been passed yet, mark it and increment count
            if (!passed[level]) {
                passed[level] = true;
                uniqueCount++;
            }
        }
        
        // --- Final Evaluation ---
        // If the unique count of passed levels equals total levels, they win
        if (uniqueCount == n) {
            System.out.println("I become the guy.");
        } else {
            System.out.println("Oh, my keyboard!");
        }
    }
}