// A. Kefa and First Steps
// time limit per test2 seconds
// memory limit per test256 megabytes
// Kefa decided to make some money doing business on the Internet for exactly n days. He knows that on the i-th day (1 ≤ i ≤ n) he makes ai money. Kefa loves progress, that's why he wants to know the length of the maximum non-decreasing subsegment in sequence ai. Let us remind you that the subsegment of the sequence is its continuous fragment. A subsegment of numbers is called non-decreasing if all numbers in it follow in the non-decreasing order.

// Help Kefa cope with this task!

// Input
// The first line contains integer n (1 ≤ n ≤ 105).

// The second line contains n integers a1,  a2,  ...,  an (1 ≤ ai ≤ 109).

// Output
// Print a single integer — the length of the maximum non-decreasing subsegment of sequence a.

// Examples
// InputCopy
// 6
// 2 2 1 3 4 1
// OutputCopy
// 3
// InputCopy
// 3
// 2 2 9
// OutputCopy
// 3
// Note
// In the first test the maximum non-decreasing subsegment is the numbers from the third to the fifth one.

// In the second test the maximum non-decreasing subsegment is the numbers from the first to the third one.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        
        int maxLen = 1;
        int currentLen = 1;
        
        // Read the first element
        int prev = scanner.nextInt();
        
        // Loop through the remaining elements
        for (int i = 1; i < n; i++) {
            int curr = scanner.nextInt();
            
            // If it's non-decreasing, increase the current streak
            if (curr >= prev) {
                currentLen++;
            } else {
                // Otherwise, update the max and reset the streak
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
            }
            // Move forward
            prev = curr;
        }
        
        // Final check in case the longest streak ends at the very last element
        maxLen = Math.max(maxLen, currentLen);
        
        System.out.println(maxLen);
        scanner.close();
    }
}