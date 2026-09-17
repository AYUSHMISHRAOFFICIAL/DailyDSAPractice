
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();

                // Print the first 'n' odd numbers
                for (int i = 0; i < n; i++) {
                    out.print((2 * i + 1) + " ");
                }
                out.println();
            }
        }

        // Flush the PrintWriter stream to output everything at once
        out.flush();
        scanner.close();
    }
}
