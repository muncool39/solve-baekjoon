import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int box = 0;
		if(N!=0){
		    int book[] = Arrays.stream(br.readLine().split(" "))
		                .mapToInt(Integer::parseInt).toArray();
		    int p = 0;
		    for(int i=0;i<N;i++){
		        p+=book[i];
		        if(p>M){
		            p=book[i];
		            box++;
		        }else if(p==M){
		            p=0;
		            box++;
		        }
		    }
		    if(p!=0){
		        box++;
		    }
		}
		System.out.print(box);
	}
}