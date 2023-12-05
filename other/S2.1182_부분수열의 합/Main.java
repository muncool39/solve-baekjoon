import java.io.*;
import java.util.*;
public class Main {
    static int N, S;
    static long[] numbers;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = Arrays.stream(br.readLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();
        dfs(0, 0);
        if(S==0) count--;
        System.out.print(count);
    }
    static void dfs(int next, long sum){
        if(next==N){
            if(sum==S) count++;
            return;
        }
        dfs(next+1, sum);
        dfs(next+1, sum+numbers[next]);
    }
}