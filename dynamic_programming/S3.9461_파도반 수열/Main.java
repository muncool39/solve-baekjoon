import java.io.*;

public class Main{
    static long[] samgak = new long[101];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    samgak[1] = 1;
	    samgak[2] = 1;
	    samgak[3] = 1;
	    samgak[4] = 2;
	    samgak[5] = 2;
	    StringBuilder sb = new StringBuilder("");
	    int T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++) {
	        int N = Integer.parseInt(br.readLine());
	        if(samgak[N] < 1) samgak[N] = findSamgak(N);
	        sb.append(samgak[N]).append("\n");
	    }
	    System.out.print(sb);
	}
	
	public static long findSamgak(int n) {
	    if(n < 6 || samgak[n] > 0) return samgak[n];
	    samgak[n] = findSamgak(n-1) + findSamgak(n-5);
	    return samgak[n];
	}
}