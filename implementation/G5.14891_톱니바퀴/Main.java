import java.io.*;
import java.util.*;

public class Main {
    static int[][] cogwheel = new int[4][8];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for(int i=0;i<4;i++) {
	        String[] input = br.readLine().split("");
	        for(int j=0;j<8;j++) {
	            cogwheel[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    int K = Integer.parseInt(br.readLine());
	    for(int i=0;i<K;i++) {
	        String[] input = br.readLine().split(" ");
	        int cr = Integer.parseInt(input[0]) - 1;
	        int dr = Integer.parseInt(input[1]);
	        int[] change = new int[4];
	        change[cr] = dr;
	        Queue<Integer> que = new LinkedList<>();
	        que.add(cr);
	        while(que.size() > 0) {
	            int now = que.poll();
	            if(now > 0 && change[now-1] == 0 && (cogwheel[now][6] != cogwheel[now-1][2])) {
	                change[now-1] = change[now] * -1;
	                que.add(now-1);
	            }
	            if(now < 3 && change[now+1] == 0 && (cogwheel[now][2] != cogwheel[now+1][6])) {
	                change[now+1] = change[now] * -1;
	                que.add(now+1);
	            }
	        }
	        for(int j=0;j<4;j++) {
	            Rotation(j, change[j]);
	        }
	    }
	    
	    int[] score = {1, 2, 4, 8};
	    int sum = 0;
	    for(int i=0;i<4;i++) {
	        if(cogwheel[i][0] == 1) {
	            sum+=score[i];
	        }
	    }
	    System.out.print(sum);
	}
	
	private static void Rotation(int num, int dir) {
	    if(dir == 0) {
	        return;
	    }
	    int[] copy = cogwheel[num].clone();
	    int w = (dir > 0) ? -1 : 1;
	    for(int i=0;i<8;i++) {
	        int nuwD = i+w;
	        if(nuwD < 0) {
	            nuwD = 7;
	        }
	        cogwheel[num][i] = copy[nuwD%8];
	    }
	}
}