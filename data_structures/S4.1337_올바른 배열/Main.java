import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    HashSet<Long> set = new HashSet<>();
	    for(int i=0;i<N;i++) {
	        set.add(Long.parseLong(br.readLine()));
	    }
	    Iterator<Long> iterator = set.iterator();
	    int min = 4;
	    while(iterator.hasNext()) {
	        long num = iterator.next();
	        int p = 4;
	        for(long i=num+1;i<num+5;i++) {
	            if(set.contains(i)) {
	                p--;
	            }
	        }
	        min = Math.min(min, p);
	        if(min == 0) {
	            break;
	        }
	    }
	    System.out.print(min);
	}
}
