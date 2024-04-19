import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    long K = Long.parseLong(st.nextToken());
	    long[] distance = new long[N+1];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<N;i++) {
	        distance[i] = Long.parseLong(st.nextToken());
	    }
	    int course = 0;
	    for(int i=0;i<N;i++) {
	        K-=distance[i];
	        if(K < 0) {
	            course = i+1;
	            break;
	        }
	        
	    }
	    if(K > 0) {
	        for(int i=N-1;i>=0;i--) {
	            K-=distance[i];
	            if(K < 0) {
	                course = i+1;
	                break;
	            }
	        }
	    }
	    System.out.print(course);
	}
}