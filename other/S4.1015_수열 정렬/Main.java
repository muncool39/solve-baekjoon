import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] arrA = Arrays.stream(br.readLine().split(" "))
	                        .mapToInt(Integer::parseInt).toArray();
	    int[] copyA = arrA.clone();
	    Arrays.sort(arrA);
	    ArrayList<Integer>[] turn = new ArrayList[1001];
	    for(int i=0;i<=1000;i++) {
	        turn[i] = new ArrayList<>();
	    }
	    for(int i=0;i<N;i++) {
	        turn[arrA[i]].add(i);
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int number : copyA) {
	        sb.append(turn[number].remove(0)).append(" ");
	    }
	    System.out.print(sb.toString());
	}
}