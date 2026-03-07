import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int B = Integer.parseInt(input[0]);
	    int C = Integer.parseInt(input[1]);
	    int D = Integer.parseInt(input[2]);
	    ArrayList<Integer>[] list = new ArrayList[3];
	    for(int i=0;i<3;i++) {
	        list[i] = new ArrayList<>();
	    }
	    int setNum = Math.min(B, Math.min(C, D));
	    long sum = 0;
	    long set = 0;
	    for(int i=0;i<3;i++) {
	        String[] price = br.readLine().split(" ");
	        for(int j=0;j<price.length;j++) {
	            int p = Integer.parseInt(price[j]);
	            list[i].add(p);
	            sum+=p;
	        }
	        Collections.sort(list[i], Collections.reverseOrder());
	        for(int j=0;j<setNum;j++) {
	            set+=list[i].get(j);
	        }
	    }
	    System.out.println(sum);
	    System.out.print(sum - set / 10);
	}
}