import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] nums = new int[n+1];
	    int[] maxs = new int[n+1];
	    for(int i=1;i<=n;i++) {
	        nums[i] = Integer.parseInt(br.readLine());
	    }
	    maxs[1] = nums[1];
	    if(n > 1) {
	        maxs[2] = maxs[1] + nums[2];
	    }
	    for(int i=3;i<=n;i++) {
	        maxs[i] = Math.max(maxs[i-1], Math.max(maxs[i-2]+nums[i], maxs[i-3]+nums[i-1]+nums[i]));
	    }
	    System.out.print(maxs[n]);
	}
}