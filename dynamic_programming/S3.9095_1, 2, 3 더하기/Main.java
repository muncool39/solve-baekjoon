import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++){
		    int n = Integer.parseInt(br.readLine());
		    int lst[] = new int[12];
		    lst[0]=0;lst[1]=1;lst[2]=2;lst[3]=4;
		    for(int j=4;j<=n;j++){
		        lst[j]=lst[j-1]+lst[j-2]+lst[j-3];
		    }
		    System.out.println(lst[n]);
		}
		
	}
}