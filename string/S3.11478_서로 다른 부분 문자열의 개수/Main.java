import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] SList = br.readLine().split("");
	    HashSet<String> set = new HashSet<>();
	    for(int i=0;i<SList.length;i++) {
	        String str = SList[i];
	        set.add(str);
	        StringBuilder sb = new StringBuilder("");
	        sb.append(str);
	        for(int j=i+1;j<SList.length;j++) {
	            sb.append(SList[j]);
	            set.add(sb.toString());
	        }
	    }
	    System.out.print(set.size());
	}
	
}