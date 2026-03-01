import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] nums = new int[N];
	    String[] input = br.readLine().split(" ");
	    for(int i=0;i<N;i++) {
	        nums[i] = Integer.parseInt(input[i]);
	    }
	    int[] up = new int[N];
	    int[] down = new int[N];
	    up[0] = 1;
	    down[0] = 1;
	    int max = 1;
	    for(int i=1;i<N;i++) {
	        if(nums[i] <= nums[i-1]) {
	            down[i] = down[i-1] + 1;
	        } else {
	            max = Math.max(down[i-1], max);
	            down[i] = 1;
	        }
	        if(nums[i] >= nums[i-1]) {
	            up[i] = up[i-1] + 1;
	        } else {
	            max = Math.max(up[i-1], max);
	            up[i] = 1;
	        }
	    }
	    max = Math.max(max, up[N-1]);
	    max = Math.max(max, down[N-1]);
	    System.out.print(max);
	}
}