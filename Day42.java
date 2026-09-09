import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            
            int nchojCost = 0;
            
            // Iterate over each farm (each farm has k fields)
            for (int i = 0; i < n; i += k) {
                boolean allNhoj = true;
                
                // Check the fields in the current farm
                for (int j = 0; j < k; j++) {
                    if (s.charAt(i + j) == '0') {
                        allNhoj = false;
                        break; // Found a free field, no need to check the rest of this farm
                    }
                }
                
                // If all fields in this farm are owned by Nhoj, we must build on his land
                if (allNhoj) {
                    nchojCost++;
                }
            }
            
            System.out.println(nchojCost);
        }
        
        scanner.close();
    }
}
