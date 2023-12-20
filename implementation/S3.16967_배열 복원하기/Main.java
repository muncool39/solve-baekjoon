import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] ArrayB = new int[H][W];
		int[][] ArrayA = new int[H][W];
		StringBuilder sb = new StringBuilder("");
		for(int h=0;h<H;h++){
		    String[] num = br.readLine().split(" ");
		    for(int w=0;w<W;w++){
		        ArrayB[h][w] = Integer.parseInt(num[w]);
		        if(h<X || w<Y){
		            ArrayA[h][w] = ArrayB[h][w];
		            sb.append(ArrayA[h][w]).append(" ");
		            continue;
		        }
		        ArrayA[h][w] = ArrayB[h][w] - ArrayA[h-X][w-Y];
		        sb.append(ArrayA[h][w]).append(" ");
            }
            sb.append("\n");
        }
		for(int i=0;i<X;i++){
		    br.readLine();
		}
		System.out.print(sb);
	}
}