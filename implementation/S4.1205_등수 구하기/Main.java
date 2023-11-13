import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    int N = Integer.parseInt(st.nextToken());
	    long teasuScore = Long.parseLong(st.nextToken());
	    int P = Integer.parseInt(st.nextToken());
	    int teasuRank = 1;
	    if(N>0){
	        long[] scores = Arrays.stream(br.readLine().split(" "))
	                            .mapToLong(Long::parseLong).toArray();
	        int[] rank = new int[N];
	        rank[0] = 1;
	        int rankCount = 1;
	        //랭크 초기화
	        for(int i=1;i<N;i++){
	            if(scores[i]==scores[i-1]){
	                    rankCount++;
	                    rank[i] = rank[i-1];
	            }else{
	                rank[i] = rank[i-1] + rankCount;
	                rankCount = 1;
	            }
	        }
	        teasuRank = 0;
	        //태수랭킹 구하기
	        for(int i=0;i<N;i++){
	            if(scores[i]<=teasuScore){
	                teasuRank = rank[i];
	                if(scores[i]==teasuScore){
	                    int plus = 1;
	                    for(int j=i+1;j<N;j++){
	                        if(scores[j]!=teasuScore) break;
	                        plus++;
	                    }
	                    if(i+plus>=P) teasuRank = -1;
	                }
	                break;
	            }
	        }
	        if(teasuRank == 0){
	            if(N<P){
	                int plus = 1;
	                for(int i=N-1;i>0;i--){
	                    if(scores[i]!=scores[i-1]) break;
	                    plus++;
	                }
	                teasuRank = rank[N-1] + plus;
	            }
	            else teasuRank = -1;
	        }
	    }//N if문 끝
	    System.out.print(teasuRank);
	}
}