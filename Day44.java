import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O for better performance
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            String s = br.readLine().trim();
            String maxFinal = "";
            
            // Alice simulates deleting every possible '0'
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    String tStr = s.substring(0, i) + s.substring(i + 1);
                    
                    // Bob plays optimally on the intermediate string
                    String minFinal = getBobsOptimal(tStr);
                    
                    // Alice wants the lexicographically largest final string
                    if (maxFinal.isEmpty() || minFinal.compareTo(maxFinal) > 0) {
                        maxFinal = minFinal;
                    }
                }
            }
            out.append(maxFinal).append("\n");
        }
        
        // Print all outputs at once
        System.out.print(out);
    }
    
    private static String getBobsOptimal(String tStr) {
        int toDelete = -1;
        int lastOne = -1;
        
        // Bob wants to minimize, so he deletes the first '1' followed by a '0'.
        // If no such sequence exists, he deletes the last '1'.
        for (int j = 0; j < tStr.length(); j++) {
            if (tStr.charAt(j) == '1') {
                lastOne = j;
                if (j + 1 < tStr.length() && tStr.charAt(j + 1) == '0') {
                    toDelete = j;
                    break;
                }
            }
        }
        
        if (toDelete == -1) {
            toDelete = lastOne;
        }
        
        // Return Bob's minimized string
        return tStr.substring(0, toDelete) + tStr.substring(toDelete + 1);
    }
}
