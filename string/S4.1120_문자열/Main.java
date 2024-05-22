import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String[] A = input[0].split("");
		String[] B = input[1].split("");
		int in = B.length - A.length + 1;
		int min = A.length;
		for(int i=0;i<in;i++) {
		    int dif = 0;
		    for(int j=0;j<A.length;j++) {
		        if(A[j].equals(B[j+i])) continue;
		        dif++;
		    }
		    if(dif < min) min = dif;
		}
		System.out.print(min);
	}
}