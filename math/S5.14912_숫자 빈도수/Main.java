import java.io.*;

public class Main {
    static int digit;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
	    digit = Integer.parseInt(input[1]);
	    long frequency = 0;
	    for(int i=1;i<=n;i++) {
	        frequency += getFre(i);
	    }
	    System.out.print(frequency);
	}
	
	private static long getFre(int num) {
	    long fre = 0;
	    while(num > 0) {
	        int n = num % 10;
	        if(n == digit) {
	            fre++;
	        }
	        num /= 10;
	    }
	    return fre;
	}
}