import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		String D = input[2];
		boolean[] check = new boolean[B+1];
		int count = 0;
		for(int i=2;i<=B;i++){
		    if(!check[i]){
		        if(i>=A && String.valueOf(i).contains(D)) count++;
		        for(int j=i+i;j<=B;j+=i){
		            check[j]=true;
		        }
		    }
		}
		System.out.print(count);
	}
}