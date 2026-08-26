import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Dubstep {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        
        // Replace all consecutive occurrences of "WUB" with a single space and trim edges
        String result = s.replaceAll("(WUB)+", " ").trim();
        
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        Map<String, Integer> database = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine().trim();
            Integer count = database.get(name);

            if (count == null) {
                database.put(name, 1);
                out.println("OK");
            } else {
                database.put(name, count + 1);
                out.println(name + count);
            }
        }

        out.flush();
    }
}