import java.io.*;
public class Main {
    static int N;
    static String str = "";
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0,str);
		System.out.print(sb);
	}
	static void dfs(int d,String n){
	    if(d!=0&&!check(Integer.parseInt(n))){
	        return;
	    }
	    if(d==N){
	        sb.append(n).append("\n");
	        return;
	    }
	    for(int i=0;i<10;i++){
            str =  n + Integer.toString(i);
	        dfs(d+1,str);
	    }
	}
	static boolean check(int n){
	    if(n<2)
	        return false;
	    for(int i=2;i<=Math.sqrt(n);i++){
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}