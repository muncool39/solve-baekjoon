import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,String> members = new HashMap<>(100000);
		HashMap<String,String> groups = new HashMap<>(100);
		while(N>0){
		    String group = br.readLine();
		    ArrayList<String> groupmem = new ArrayList<>();
		    int psn = Integer.parseInt(br.readLine());
		    for(int i=0;i<psn;i++){
		        String member = br.readLine();
		        members.put(member,group);
		        groupmem.add(member);
		    }
		    Collections.sort(groupmem);
		    StringBuilder sb = new StringBuilder("");
		    for(String mem : groupmem){
		        sb.append(mem).append("\n");
		    }
		    groups.put(group,sb.toString());
		    N--;
		}
		StringBuilder sb = new StringBuilder("");
		while(M>0){
		    String Q = br.readLine();
		    int a = Integer.parseInt(br.readLine());
		    String A = (a==1)?members.get(Q)+"\n":groups.get(Q);
		    sb.append(A);
		    M--;
		}
		System.out.print(sb);
	}
}