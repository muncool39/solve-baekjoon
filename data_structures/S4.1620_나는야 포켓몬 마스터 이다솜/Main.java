import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,String> pokemon = new HashMap(N);
		for(int i=1;i<=N;i++){
		    String str = br.readLine();
		    String snum = Integer.toString(i);
		    pokemon.put(snum,str);
		    pokemon.put(str,snum);
		}
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<M;i++){
		    sb.append(pokemon.get(br.readLine())).append("\n");
		}
		System.out.print(sb);
	}
}