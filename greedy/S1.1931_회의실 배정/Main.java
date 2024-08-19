import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<long[]> arr = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        arr.add(new long[]{Long.parseLong(input[0]), Long.parseLong(input[1])});
	    }
	    arr.sort((o1, o2) -> {
            int firstCompare = Long.compare(o1[1], o2[1]);
            return firstCompare != 0 ? firstCompare : Long.compare(o1[0], o2[0]);
        });
        int count = 0;
        long next = 0;
        for(long[] meeting : arr) {
            if(meeting[0] >= next) {
                count++;
                next = meeting[1];
            }
        }
        System.out.print(count);
	}
}