import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<n;i++){
		    String[] status = br.readLine().split(" ");
		    int Ti = Integer.parseInt(status[0]);
		    HashMap<String,Integer> counts = new HashMap<>(Ti);
		    for(int idx=1;idx<status.length;idx++){
		        String soldierNumber = status[idx];
		        if(counts.containsKey(soldierNumber)){
		            int c = counts.get(soldierNumber)+1;
		            counts.replace(soldierNumber,c);
		            continue;
		        }
		        counts.putIfAbsent(soldierNumber,1);
		    }
		    List<String> soldierNumbers = new ArrayList<>(counts.keySet());
		    soldierNumbers.sort(new Comparator<String>() {
		        public int compare(String soldier1, String soldier2){
		            return counts.get(soldier2).compareTo(counts.get(soldier1));
		        }
		    });
		    if(counts.get(soldierNumbers.get(0))>(Ti/2)){
		        sb.append(soldierNumbers.get(0)).append("\n");
		        continue;
		    }
		    sb.append("SYJKGW").append("\n");
		}
		System.out.print(sb);
	}
}