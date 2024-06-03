import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    String[][] puzzle = new String[N][M];
	    for(int i=0;i<N;i++) {
	        puzzle[i] = br.readLine().split("");
	    }
	    int count = 0;
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<M;j++){
	            String start = puzzle[i][j];
	            if(start.equals("#")) continue;
	            boolean isClue = false;
	            if(i+2<N && (i==0 || puzzle[i-1][j].equals("#"))) {
	                if(puzzle[i+1][j].equals(".") && puzzle[i+2][j].equals(".")){
	                    isClue = true;
	                }
	            }
	            if(j+2<M && (j==0 || puzzle[i][j-1].equals("#"))) {
	                if(puzzle[i][j+1].equals(".") && puzzle[i][j+2].equals(".")){
	                    isClue = true;
	                }
	            }
	            if(isClue) {
	                count++;
	                sb.append(i+1).append(" ").append(j+1).append("\n");
	            }
	        }
	    }
	    System.out.println(count);
	    System.out.print(sb);
	}
}