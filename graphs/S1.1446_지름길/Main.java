import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = convert(st.nextToken());
	    int D = convert(st.nextToken());
	    ArrayList<int[]> shortcut = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int s = convert(st.nextToken());
	        int e = convert(st.nextToken());
	        int l = convert(st.nextToken());
	        shortcut.add(new int[]{s, e, l});
	    }
	    int[] length = new int[D+1];
	    for(int i=1;i<=D;i++) {
	        length[i] = length[i-1] + 1;
	        for(int[] sc : shortcut) {
	            if(sc[1] == i) {
	                int ct = length[sc[0]] + sc[2];
	                length[i] = Math.min(length[i], ct);
	            }
	        }
	    }
	    System.out.print(length[D]);
	}
	
	private static int convert(String str) {
	    return Integer.parseInt(str);
	}
}