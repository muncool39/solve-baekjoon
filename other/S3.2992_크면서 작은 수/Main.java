import java.io.*;
import java.util.*;
public class Main{
    static int X;
    static int[] numbers;
    static boolean[] visited;
    static ArrayList<Integer> numArray = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    X = Integer.parseInt(input);
	    numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
	    visited = new boolean[input.length()];
	    dfs(0, 0);
	    int answer = 0;
	    if(!numArray.isEmpty()) {
	        Collections.sort(numArray);
	        answer = numArray.get(0);
	    }
	    System.out.print(answer);
	}
	
	static void dfs(int deep, int number) {
	    if(deep==numbers.length) {
	        if(number>X) {
	            numArray.add(number);
	        }
	    }
	    for(int i=0;i<numbers.length;i++) {
	        if(visited[i]) continue;
	        visited[i] = true;
	        dfs(deep+1, number*10 + numbers[i]);
	        visited[i] = false;
	    }
	}
}