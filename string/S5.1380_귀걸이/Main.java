import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int scenarioNumber = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            scenarioNumber++;
            String[] students = new String[n+1];
            for (int i = 1; i <= n; i++) {
                students[i] = br.readLine();
            }
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int i=1; i<=2*n-1; i++) {
                String[] parts = br.readLine().split(" ");
                int num = Integer.parseInt(parts[0]);
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
            for (int i=1; i<=n; i++) {
                if (count.getOrDefault(i, 0)%2!=0) {
                    sb.append(scenarioNumber).append(" ").append(students[i]).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}