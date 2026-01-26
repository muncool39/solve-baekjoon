import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Integer> crane = new ArrayList<>();
	    ArrayList<Integer> box = new ArrayList<>();
	    
	    br.readLine();
	    String[] c_input = br.readLine().split(" ");
	    for(String c : c_input) {
	        crane.add(Integer.parseInt(c));
	    }
	    br.readLine();
	    String[] b_input = br.readLine().split(" ");
	    for(String b : b_input) {
	        box.add(Integer.parseInt(b));
	    }
	    
	    Collections.sort(crane, Collections.reverseOrder());
	    Collections.sort(box, Collections.reverseOrder());
	    
	    if(crane.get(0) < box.get(0)) {
	        System.out.print(-1);
	        return;
	    }
	    int time = 0;
	    while(box.size() > 0) {
	        time++;
	        for(int cSize : crane) {
	            for(int i=0;i<box.size();i++) {
	                if(cSize >= box.get(i)) {
	                    box.remove(i);
	                    break;
	                }
	            }
	        }
	    }
	    System.out.print(time);
	}
}
