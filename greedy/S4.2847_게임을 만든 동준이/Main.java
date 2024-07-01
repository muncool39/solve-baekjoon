import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] score = new int[N];
	    for(int i=0;i<N;i++) {
	        score[i] = Integer.parseInt(br.readLine());
	    }
	    int count = 0;
	    for(int i=N-2;i>=0;i--) {
	        int next = score[i+1];
	        int now = score[i];
	        if(now >= next) {
	            count+= now-next+1;
	            score[i] = next-1;
	        }
	    }
	    System.out.print(count);
	}
}