import java.io.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		long arr[] = new long[20000000];
		for(long i=2;i<arr.length;i++) {
			if(arr[(int) i]==0) {
				K--;
				if(K==0) {
					System.out.print(i);
					break;
				}
				for(long j=i+i;j<arr.length&&j>1;j+=i) {
					arr[(int) j]=1;
				}
			}
		}
	}
}