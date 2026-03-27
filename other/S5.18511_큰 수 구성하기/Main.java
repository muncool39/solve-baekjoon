import java.io.*;
import java.util.*;


public class Main {
    static int N, K, ans = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    String[] Ns = input[0].split("");
	    N = Ns.length;
	    K = Integer.parseInt(input[1]);
	    
	    int[] nArray = new int[N];
	    for(int i=0;i<N;i++) {
	        nArray[i] = Integer.parseInt(Ns[i]);
	    }
	    int[] kArray = new int[K];
	    String[] kinput = br.readLine().split(" ");
	    for(int i=0;i<K;i++) {
	        kArray[i] = Integer.parseInt(kinput[i]);
	    }
	    
	    Arrays.sort(kArray);
	    
	    int first = nArray[0];
	    if(kArray[0] > first) {
	        int num = repeatMake(kArray[K-1], N-1);
	        System.out.print(num);
	        return;
	    }
	    
	    dfs(0, 0, nArray, kArray);
	    if(!find) {
	        ans = repeatMake(kArray[K-1], N-1);
	    }
	    System.out.print(ans);
	    
	}
	static boolean find = false;
	
	private static void dfs(int index, int num, int[] nArray, int[] kArray) {
	    if(find) {
	        return;
	    }
	    if(index == N) {
	        ans = num;
	        find = true;
	        return;
	    }
	    
	    for(int i=K-1;i>=0;i--) {
	        int now = nArray[index];
	        if(now == kArray[i]) {
	            dfs(index+1, num*10+kArray[i], nArray, kArray);
	            if(find) {
	                return;
	            }
	        } else if(now > kArray[i]) {
	            ans = num * (int) Math.pow(10, N-index);
	            ans+=kArray[i] * (int) Math.pow(10, N-index-1);
	            ans+=repeatMake(kArray[K-1], N-index-1);
	            
	            find = true;
	            return;
	        }
	    }
	}
	
	private static int smallNum(int n, int[] list) {
	    for(int i=K-1;i>=0;i--) {
	        if(n > list[i]) {
	            return list[i];
	        }
	    }
	    return -1;
	}
	
	private static int repeatMake(int n, int count) {
	    int num = 0;
	    for(int i=0;i<count;i++) {
	        num+=n;
	        num*=10;
	    }
	    return num/10;
	}
}