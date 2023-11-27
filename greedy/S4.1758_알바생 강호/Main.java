import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> tips = new ArrayList<>();
		for(int i=0;i<N;i++){
		    tips.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(tips, Collections.reverseOrder());
		long maxSum = 0;
		for(int i=0;i<N;i++){
		    int tip = tips.get(i) - i;
		    if(tip<0) break;
		    maxSum+=tip;
		}
		System.out.print(maxSum);
	}
}