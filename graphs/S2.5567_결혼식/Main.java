import java.io.*;
import java.util.*;
public class Main{
    static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		visited[1] = true;
		ArrayList<Integer>[] friendship = new ArrayList[n+1];
		for(int i=1;i<=n;i++){
		    friendship[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++){
		    String[] friend = br.readLine().split(" ");
		    int a = Integer.parseInt(friend[0]);
		    int b = Integer.parseInt(friend[1]);
		    friendship[a].add(b);
		    friendship[b].add(a);
		}
		int count = 0;
		for(int i=0;i<friendship[1].size();i++){
		    int friend = friendship[1].get(i);
		    if(!visited[friend]){
		        count++;
		        visited[friend] = true;
		    } 
		    for(int j=0;j<friendship[friend].size();j++){
		        int friendsfriend = friendship[friend].get(j);
		        if(visited[friendsfriend]) continue;
		        visited[friendsfriend] = true;
		        count++;
		    }
		}
		System.out.print(count);
	}
}