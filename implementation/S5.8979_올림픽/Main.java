import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int K = Integer.parseInt(input[1]);
	    int[][] list = new int[N][4];
	    for(int i=0;i<N;i++) {
	        String[] medal = br.readLine().split(" ");
	        for(int j=0;j<4;j++) {
	            list[i][j] = Integer.parseInt(medal[j]);
	        }
	    }
	    Arrays.sort(list, (o1, o2)-> {
	      if(o1[1]!=o2[1]) return Integer.compare(o2[1], o1[1]);
	      if(o1[2]!=o2[2]) return Integer.compare(o2[2], o1[2]);
	      return Integer.compare(o2[3], o1[3]);
	    });
	    int rank = 1, nextRank = 2;
	    int[] ranklist = new int[N+1];
	    ranklist[list[0][0]] = 1;
	    for(int i=1;i<=N;i++) {
	        if(list[i-1][1]==list[i][1]
	        && list[i-1][2]==list[i][2]
	        && list[i-1][3]==list[i][3]) {
	            ranklist[list[i][0]] = rank;
	            nextRank++;
	        } else {
	            ranklist[list[i][0]] = nextRank;
	            rank = nextRank;
	            nextRank++;
	        }
	        if(K==1 || list[i][0]==K) break;
	    }
	    System.out.print(ranklist[K]);
	}
}