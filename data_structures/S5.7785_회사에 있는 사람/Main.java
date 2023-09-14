import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String ,String> log = new HashMap<>(n);
		for(long i=0;i<n;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    String name = st.nextToken();
		    String status = st.nextToken();
		    log.put(name,status);
		}
		ArrayList<String> nameSet = new ArrayList<>(log.keySet());
		Collections.sort(nameSet,Collections.reverseOrder());
		StringBuilder sb = new StringBuilder("");
		for(String name : nameSet){
		    if(log.get(name).equals("enter")){
		        sb.append(name).append("\n");
		    }
		}
		System.out.print(sb);
	}
}