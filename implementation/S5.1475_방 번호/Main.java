import java.io.*;

public class Main{
    static int[] numSetCount = new int[10];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] N = br.readLine().split("");
	    for(String roomNumber : N) {
	        int index = Integer.parseInt(roomNumber);
	        if(index==9 || index==6) {
	            index = checkReverse(index);
	        }
	        numSetCount[index]++;
	    }
	    int max = 0;
	    for(int count : numSetCount){
	        max = Math.max(max, count);
	    }
	    System.out.print(max);
	}
	public static int checkReverse(int index){
	    if(numSetCount[6] < numSetCount[9]) return 6;
	    if(numSetCount[6] > numSetCount[9]) return 9;
	    return index;
	}
}