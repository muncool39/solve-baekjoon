import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		int D[] = new int[N];
		for(int i=0;i<N;i++){
		    D[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(D);
        int kl=C/A;int k=1;int sum=C;
        for(int i=D.length-1;i>=0;i--){
            sum+=D[i];
            if(kl<=sum/(A+B*k)){
                kl=sum/(A+B*k);
                k++;
            }else
                break;
        }
        System.out.print(kl);
	}
}
