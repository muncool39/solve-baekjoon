import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        list.add(Integer.parseInt(br.readLine()));
	    }
	    list.sort(Comparator.naturalOrder());
	    StringBuilder sb = new StringBuilder("");
	    for(int n : list) {
	        sb.append(n).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}