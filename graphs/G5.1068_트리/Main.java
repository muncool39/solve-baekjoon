import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<Integer>[] list = new ArrayList[N];
	    for(int i=0;i<N;i++) {
	        list[i] = new ArrayList<>();
	    }
	    String[] node = br.readLine().split(" ");
	    int deleteN = Integer.parseInt(br.readLine());
	    int root = 0;
	    for(int i=0;i<N;i++) {
	        int p = Integer.parseInt(node[i]);
	        if(p == -1) {
	            root = i;
	            continue;
	        }
	        if(i == deleteN || p == deleteN) {
	            continue;
	        }
	        list[p].add(i);
	    }
	    if(root == deleteN) {
	        System.out.print(0);
	        return;
	    }
	    Queue<Integer> que = new LinkedList<>();
	    que.add(root);
	    int count = 0;
	    while(que.size() > 0) {
	        int now = que.poll();
	        if(list[now].size() == 0) {
	            count++;
	        } else {
	            for(int next : list[now]) {
	                que.add(next);
	            }
	        }
	    }
	    System.out.print(count);
	}
}