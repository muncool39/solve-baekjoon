import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int deep = 0;
    static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++){
		    arr[i] = new ArrayList<Integer>();
		}
		num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    arr[x].add(y);
		    arr[y].add(x);
		}
		dfs(num[0],0);
		if(deep==0) deep=-1;
		System.out.print(deep);
	}
    static void dfs(int now,int d){
        visited[now] = true;
        for(int n : arr[now]){
            if(visited[n]) continue;
            if(n==num[1]){
                deep = d+1;
                break;
            }
            dfs(n,d+1);
        }
    }
}