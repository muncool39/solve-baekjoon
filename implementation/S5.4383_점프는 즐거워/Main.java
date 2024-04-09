import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder answer = new StringBuilder("");
	    while(true) {
	        String line = br.readLine();
	        if(line == null || line.isEmpty()) break;
	        StringTokenizer st = new StringTokenizer(line, " ");
            int n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];
            boolean[] cheak = new boolean[n];
            for(int i=0;i<n;i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            String jumper = "Jolly";
            for(int i=0;i<n-1;i++) {
                int dif = Math.abs(numbers[i]-numbers[i+1]);
                if(dif >= n || cheak[dif]) {
                    jumper = "Not jolly";
                    break;
                }
                cheak[dif] = true;
            }
            answer.append(jumper).append("\n");
	    }
	    System.out.print(answer);
	}
}