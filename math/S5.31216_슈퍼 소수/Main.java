import java.io.*;
public class Main{
    static int[] superSosus = new int[3001];
    static boolean[] nonsosu = new boolean[318138];
	public static void main(String[] args) throws IOException {
	    setting();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		while(T>0){
		    int index = Integer.parseInt(br.readLine());
		    sb.append(superSosus[index]).append("\n");
		    T--;
		}
		System.out.print(sb);
	}
	static void setting(){
	    nonsosu[1] = true;
	    int k = 0;
	    int supercount = 0;
	    for(int i=2;i<nonsosu.length;i++){
	        if(!nonsosu[i]){
	            k++;
	            for(int j=i+i;j<nonsosu.length;j+=i){
	                nonsosu[j] = true;
	            }
	            if(!nonsosu[k]) superSosus[++supercount] = i;
	        }
	    }
	}
}