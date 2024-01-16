import java.io.*;

public class Main{
    static int R, C;
    static int[][] counts;
    static int[] xDirection = {1,-1,0,0,1,1,-1,-1};
    static int[] yDirection = {0,0,1,-1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    while(true){
	        String[] input = br.readLine().split(" ");
	        R = Integer.parseInt(input[0]);
	        C = Integer.parseInt(input[1]);
	        if(R==0 && C==0) break;
	        counts = new int[R][C];
	        for(int x=0;x<R;x++){
	            String[] minefield = br.readLine().split("");
	            for(int y=0;y<C;y++){
	                if(minefield[y].equals("*")){
	                    counts[x][y] = -1;
	                    check(x, y);
	                }
	            }
	        }
	        for(int x=0;x<R;x++){
	            for(int y=0;y<C;y++){
	                if(counts[x][y]<0){
	                    sb.append("*");
	                    continue;
	                }
	                sb.append(counts[x][y]);
	            }
	            sb.append("\n");
	        }
	    }
	    System.out.print(sb);
	}
	
	static void check(int xnow, int ynow){
	    for(int i=0;i<8;i++){
	        int nextx = xnow + xDirection[i];
	        int nexty = ynow + yDirection[i];
	        if(nextx<0 || nexty<0 || nextx>=R || nexty>=C) continue;
	        if(counts[nextx][nexty]<0) continue;
	        counts[nextx][nexty]++;
	    }
	}
}