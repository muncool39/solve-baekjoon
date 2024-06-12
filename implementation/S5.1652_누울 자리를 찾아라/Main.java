import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[][] room = new String[N][N];
	    for(int i=0;i<N;i++) {
	        room[i] = br.readLine().split("");
	    }
	    int garo = 0;
	    for(int x=0;x<N;x++) {
	        for(int y=0;y<N-1;y++) {
	            if(room[x][y].equals("X")) continue;
	            int count = 1;
	            for(int i=y+1;i<N;i++) {
	                if(room[x][i].equals("X")) break;
	                count++;
	            }
	            if(count >= 2) garo++;
	            y += count;
	        }
	    }
	    int sero = 0;
	    for(int y=0;y<N;y++) {
	        for(int x=0;x<N-1;x++) {
	            if(room[x][y].equals("X")) continue;
	            int count = 1;
	            for(int i=x+1;i<N;i++) {
	                if(room[i][y].equals("X")) break;
	                count++;
	            }
	            if(count >= 2) sero++;
	            x += count;
	        }
	    }
	    System.out.print(garo+" "+sero);
	}
}