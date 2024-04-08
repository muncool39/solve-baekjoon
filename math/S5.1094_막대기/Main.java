import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int X = Integer.parseInt(br.readLine());
	    int sum = 64;
	    int min = 64;
	    int count = 1;
	    while(sum!=X) {
	        count++;
	        min = min/2;
	        if(sum-min >= X) {
	            sum-=min;
	            count--;
	        }
	    }
		System.out.println(count);
	}
}