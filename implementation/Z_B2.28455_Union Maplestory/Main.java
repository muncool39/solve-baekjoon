import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] level = new int[N];
	    for(int i=0;i<N;i++) {
	        level[i] = Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(level);
	    int index = N - 1;
	    int count = 1;
	    int levelSum = 0;
	    int upSum = 0;
	    while(index >= 0 && count <= 42) {
	        levelSum+=level[index];
	        upSum+=upCalc(level[index]);
	        count++;
	        index--;
	    }
	    System.out.print(levelSum+" "+upSum);
	}
	
	private static int upCalc(int level) {
	    int[] standard = {60, 100, 140, 200, 250};
	    int up = 0;
	    for(int s : standard) {
	        if(level >= s) {
	            up++;
	        } else {
	            break;
	        }
	    }
	    return up;
	}
}