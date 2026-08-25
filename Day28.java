import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> programmers = new ArrayList<>();
        List<Integer> mathematicians = new ArrayList<>();
        List<Integer> sportsmen = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                programmers.add(i);
            } else if (t == 2) {
                mathematicians.add(i);
            } else if (t == 3) {
                sportsmen.add(i);
            }
        }
        
        int totalTeams = Math.min(programmers.size(), Math.min(mathematicians.size(), sportsmen.size()));
        
        StringBuilder sb = new StringBuilder();
        sb.append(totalTeams).append("\n");
        
        for (int i = 0; i < totalTeams; i++) {
            sb.append(programmers.get(i)).append(" ")
              .append(mathematicians.get(i)).append(" ")
              .append(sportsmen.get(i)).append("\n");
        }
        
        System.out.print(sb);
    }
}