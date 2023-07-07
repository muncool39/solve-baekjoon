import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int e=0;int s=0;int m=0;
		long year = 0;
		while(!((e==E&&s==S)&&m==M)){
		    e++;s++;m++;year++;
		    if(e>15)
		        e=1;
		    if(s>28)
		        s=1;
		    if(m>19)
		        m=1;
		}
		System.out.print(year);
	}
}
