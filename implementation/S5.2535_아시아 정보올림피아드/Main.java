import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<int[]> list = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        int[] score = new int[3];
	        for(int j=0;j<3;j++) {
	            score[j] = Integer.parseInt(input[j]);
	        }
	        list.add(score);
	    }
	    list.sort((o1, o2) -> {
	        return o2[2] - o1[2];
	    });
	    StringBuilder sb = new StringBuilder("");
	    int[] check = new int[N+1];
	    int count = 1;
	    for(int[] arr : list) {
	        if(count == 3 && check[arr[0]] == 2) {
	            continue;
	        }
	        check[arr[0]]++;
	        sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
	        count++;
	        if(count > 3) {
	            break;
	        }
	    }
	    System.out.print(sb.toString());
	}
}