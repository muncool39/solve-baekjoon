import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String>[] list;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    list = new ArrayList[N];
	    int maxSize = 0;
	    for(int i=0;i<N;i++) {
	        ArrayList<String> arr = new ArrayList<>();
	        String[] file = br.readLine().split(" ");
	        for(String f : file) {
	            arr.add(f);
	        }
	        arr.remove(arr.size() - 1);
	        maxSize = Math.max(maxSize, arr.size());
	        list[i] = arr;
	    }
	    int K = 0;
	    for(int i=1;i<=maxSize+1;i++) {
	        if(isPossible(i)) {
	            K = i;
	            break;
	        }
	    }
	    System.out.print(K);
	}
	
	private static boolean isPossible(int k) {
	    HashSet<String> set = new HashSet<>();
	    for(ArrayList<String> file : list) {
	        StringBuilder sb = new StringBuilder();
	        int size = file.size();
	        for(int i=0;i<k;i++) {
	            sb.append((i < size) ? file.get(i) : "0").append(",");
	        }
	        String fnum = sb.toString();
	        if(set.contains(fnum)) {
	            return false;
	        }
	        set.add(fnum);
	    }
	    return true;
	}
}