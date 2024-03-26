import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] notSosu = new boolean[100000];
    static TreeSet<Integer> sosuMap = new TreeSet<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]);
	    M = Integer.parseInt(input[1]);
	    nums = Arrays.stream(br.readLine().split(" "))
	                 .mapToInt(Integer::parseInt).toArray();
	    setSosu();
	    findSosu(0, 0, 0);
	    StringBuilder sb = new StringBuilder("");
	    Iterator iter = sosuMap.iterator();
	    while(iter.hasNext()) {
	        sb.append(iter.next()).append(" ");
	    }
	    if(sb.length()<1) sb.append("-1");
	    System.out.print(sb);
	}
	public static void setSosu() {
	    notSosu[0] = true;
	    notSosu[1] = true;
	    for(int i=2;i<100000;i++) {
	        if(notSosu[i]) continue;
	        for(int j=i+i;j<100000;j+=i) {
	            notSosu[j] = true;
	        }
	    }
	}
	public static void findSosu(int point, int count, int sum) {
	    if(count == M) {
	        if(!notSosu[sum]) {
	            sosuMap.add(sum);
	        }
	        return;
	    }
	    if(point >= N) return;
	    findSosu(point+1, count, sum);
	    findSosu(point+1, count+1, sum+nums[point]);
	}
}