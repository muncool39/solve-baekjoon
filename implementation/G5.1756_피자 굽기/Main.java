import java.io.*;

public class Main {
    static int floor;
    static long[] oven;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] DN = br.readLine().split(" ");
	    int D = Integer.parseInt(DN[0]);
	    floor = D;
	    int N = Integer.parseInt(DN[1]);
	    oven = new long[D+1];
	    String[] deep = br.readLine().split(" ");
	    long min = 1000000000;
	    for(int i=1;i<=D;i++) {
	        min = Math.min(min, Long.parseLong(deep[i-1]));
	        oven[i] = min;
	    }
	    String[] pizza = br.readLine().split(" ");
	    int location = 0;
	    for(String p : pizza) {
	        location = findLocation(Long.parseLong(p));
	        if(location == 0) {
	            break;
	        }
	        floor = location - 1;
	    }
	    System.out.print(location);
	}
	
	private static int findLocation(long size) {
	    int top = 1;
	    int bottom = floor;
	    int loc = (top + bottom) / 2;
	    
	    while(loc > 0 && loc < floor) {
	        
	        if(oven[loc] > size && oven[loc+1] < size) {
	            return loc;
	        }
	        if(oven[loc] < size && oven[loc-1] > size) {
	            return loc - 1;
	        }
	        
	        if(oven[loc] > size) {
	            top = loc + 1;
	        } else if(oven[loc] < size) {
	            bottom = loc - 1;
	        } else {
	            for(int i=loc;i<=floor;i++) {
	                if(oven[loc] > oven[i]) {
	                    return i - 1;
	                }
	            }
	            return floor;
	        }
	        
	        loc = (top + bottom) / 2;
	    }
	    
	    return loc;
	}
}