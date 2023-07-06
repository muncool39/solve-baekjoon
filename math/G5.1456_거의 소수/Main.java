import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	public static void main(String arg[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num[] = new long[10000001];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long sqB = (long) Math.sqrt(B);
		ArrayList<Long> arr = new ArrayList<>();
		for(long i=2;i<=sqB;i++) {
			if(num[(int)i]==0) {
				arr.add(i);
				for(long j=i+i;j<=sqB;j+=i) {
					num[(int)j]=1;
				}
			}
		}
		long t=1;int count=0;
		for(long n :arr) {
			t=n;
			while(t<=B/n) {
				t*=n;
				if(t>=A) {
					count++;
				}
			}
		}
		System.out.print(count);
	}
}