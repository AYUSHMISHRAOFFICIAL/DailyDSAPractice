/*
A. Theatre Square
time limit per test1 second
memory limit per test256 megabytes
Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters. On the occasion of the city's anniversary, a decision was taken to pave the Square with square granite flagstones. Each flagstone is of the size a × a.
What is the least number of flagstones needed to pave the Square? It's allowed to cover the surface larger than the Theatre Square, but the Square has to be covered. It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.
Input

The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).
Output

Write the needed number of flagstones.
Examples
InputCopy
6 6 4
OutputCopy
4 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the single line containing n, m, and a
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // Parse inputs directly as longs to prevent any overflow issues
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        
        // Calculate the number of stones needed for the length
        // Formula (n + a - 1) / a perfectly replicates Math.ceil(n / a) using integers
        long stonesN = (n + a - 1) / a;
        
        // Calculate the number of stones needed for the width
        long stonesM = (m + a - 1) / a;
        
        // The total number of stones is the product of the two
        long totalStones = stonesN * stonesM;
        
        // Output the final required number of flagstones
        System.out.println(totalStones);
    }
}