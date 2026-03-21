import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int anum = Integer.parseInt(st.nextToken());
	    int bnum = Integer.parseInt(st.nextToken());
	    int[] A = new int[anum];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<anum;i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    st = new StringTokenizer(br.readLine(), " ");
	    Set<Integer> B = new HashSet<>();
	    for(int i=0;i<bnum;i++) {
	        B.add(Integer.parseInt(st.nextToken()));
	    }
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int a : A) {
	        if(B.contains(a)) {
	            continue;
	        }
	        list.add(a);
	    }
	    System.out.println(list.size());
	    if(list.size() > 0) {
	        Collections.sort(list);
	        StringBuilder sb = new StringBuilder("");
	        for(int n : list) {
	            sb.append(n).append(" ");
	        }
	        System.out.print(sb.toString());
	    }
	}
}