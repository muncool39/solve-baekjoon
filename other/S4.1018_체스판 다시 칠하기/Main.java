import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] bord = new String[N+1][M+1];
		for(int i=1;i<=N;i++){
		    String[] BW = br.readLine().split("");
		    for(int j=1;j<=M;j++){
		        bord[i][j] = BW[j-1];
		    }
		}
		int[][] startWhite = new int[N+1][M+1];//하향색으로 시작
		int[][] startBlack = new int[N+1][M+1];//검정색으로 시작
		for(int i=1;i<=N;i++){
		    for(int j=1;j<=M;j++){
		        startBlack[i][j]=startBlack[i-1][j]+startBlack[i][j-1]-startBlack[i-1][j-1];
		        startWhite[i][j]=startWhite[i-1][j]+startWhite[i][j-1]-startWhite[i-1][j-1];
		        if(i%2!=0){//홀수줄일때
		            if(j%2!=0){//홀수번째 수
		                if(bord[i][j].equals("W")){
		                    startBlack[i][j]++;
		                }else{
		                    startWhite[i][j]++;
		                }
		            }else{//짝수번째 수
		                if(bord[i][j].equals("B")){
		                    startBlack[i][j]++;
		                }else{
		                    startWhite[i][j]++;
		                }
		            }
		        }else{//짝수줄일때
		            if(j%2!=0){//홀수번째 수
		                if(bord[i][j].equals("W")){
		                    startWhite[i][j]++;
		                }else{
		                    startBlack[i][j]++;
		                }
		            }else{//짝수번째 수
		                if(bord[i][j].equals("B")){
		                    startWhite[i][j]++;
		                }else{
		                    startBlack[i][j]++;
		                }
		            }
		        }
		    }
		}
		int min = 1000000;
		//if(startBlack[8][8]<min) min = startBlack[8][8];
		for(int i=8;i<=N;i++){
		    for(int j=8;j<=M;j++){
		        int black = startBlack[i][j]-startBlack[i-8][j]-startBlack[i][j-8]+startBlack[i-8][j-8];
		        int white = startWhite[i][j]-startWhite[i-8][j]-startWhite[i][j-8]+startWhite[i-8][j-8];
		        if(white<min) min = white;
		        if(black<min) min = black;
		    }
		}
		System.out.print(min);
	}
}