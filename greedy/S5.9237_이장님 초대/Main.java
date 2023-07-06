import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long lst[] = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong)
		    .sorted(Collections.reverseOrder()).mapToLong(Long::valueOf).toArray();
		long count = lst[0]+2;
        long imsi = lst[0];
		for(int i=1;i<N;i++){
		    imsi--;
		    if(lst[i]>imsi){
		        count++;
		        imsi=lst[i];
		    }
		        
		}
		System.out.print(count);
	}
}