import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int X = Integer.parseInt(br.readLine());
	    int A = 1;
	    int B = 1;
	    int count = 1;
	    boolean up = true;
	    while(count < X) {
	        count++;
	        if(up && A == 1) {
	            B++;
	            up = false;
	            continue;
	        }
	        if(!up && B == 1) {
	            A++;
	            up = true;
	            continue;
	        }
	        if(up) {
	            A--;
	            B++;
	        } else {
	            A++;
	            B--;
	        }
	    }
	    System.out.print(A+"/"+B);
	}
}