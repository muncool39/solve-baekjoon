import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int X = Integer.parseInt(input[1]);
	    long[] visitSum = new long[N];
	    String[] visits = br.readLine().split(" ");
	    visitSum[0] = Long.parseLong(visits[0]);
	    for(int i=1;i<N;i++) {
	        visitSum[i] = Long.parseLong(visits[i]) + visitSum[i-1];
	    }
	    long maxVisit = visitSum[X-1];
	    int day = 1;
	    for(int i=X;i<N;i++) {
	        long now = visitSum[i] - visitSum[i-X];
	        if(now < maxVisit)  continue;
	        if(now == maxVisit) {
	            day++;
	        } else {
	            maxVisit = now;
	            day = 1;
	        }
	    }
	    String ans = new StringBuilder()
	                        .append(maxVisit).append("\n").append(day).toString();
	    if(maxVisit==0) {
	        ans = "SAD";
	    }
	    System.out.print(ans);
	}
}