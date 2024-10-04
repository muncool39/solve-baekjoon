import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int count = 0;
	    for(int i=0;i<N;i++) {
	        Set<String> set = new HashSet<>();
	        boolean group = true;
	        String[] input = br.readLine().split("");
	        String before = input[0];
	        for(int j=1;j<input.length;j++) {
	            String now = input[j];
	            if(set.contains(now)) {
	                group = false;
	                break;
	            } else if (now.equals(before)) {
	                continue;
	            }
	            set.add(before);
	            before = now;
	        }
	        if(group) count++;
	    }
	    System.out.print(count);
	}
}