import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    HashSet<String> user = new HashSet<>();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int count = 0;
	    for(int i=0;i<N;i++) {
	        String log = br.readLine();
	        if(log.equals("ENTER")) {
	            user.clear();
	            continue;
	        }
	        if(user.contains(log)) continue;
	        user.add(log);
	        count++;
	    }
	    System.out.print(count);
	}
}