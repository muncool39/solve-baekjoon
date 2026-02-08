import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    int n = convert(info[0]);
	    int k = convert(info[1]);
	    ArrayList<Integer>[] list = new ArrayList[n];
	    for(int i=0;i<n;i++) {
	        list[i] = new ArrayList<>();
	    }
	    for(int i=0;i<n-1;i++) {
	        String[] edge = br.readLine().split(" ");
	        int p = convert(edge[0]);
	        int c = convert(edge[1]);
	        list[p].add(c);
	    }
	    boolean[] apple = new boolean[n];
	    String[] aInfo = br.readLine().split(" ");
	    for(int i=0;i<n;i++) {
	        apple[i] = aInfo[i].equals("1");
	    }
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{0, 0});
	    int acount = 0;
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        if(apple[now[0]]){
	            acount++;
	        }
	        if(now[1] == k) {
	            continue;
	        }
	        for(int c : list[now[0]]) {
	            que.add(new int[]{c, now[1]+1});
	        }
	    }
	    System.out.print(acount);
	}
	
	private static int convert(String str) {
	    return Integer.parseInt(str);
	}
}
