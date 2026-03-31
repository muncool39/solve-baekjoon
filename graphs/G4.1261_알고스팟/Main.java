import java.io.*;
import java.util.*;

public class Main {
    
    static class Node{
        int x;
        int y;
        int broken;
        public Node(int x,int y,int broken){
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
    
	static int N,M;
    static int map[][];
    static int ans = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++){
                   map[i][j] = str.charAt(j)-'0';
            }
        }

        findMin();
        
        System.out.println(ans);
    }
    
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void findMin() {
        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> o1.broken - o2.broken
        );
        queue.add(new Node(0,0,0));
        
        boolean visited[][] =new boolean[N][M];
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == N - 1 && node.y == M-1){
                ans = Math.min(node.broken, ans);
                return;
            }

            for (int i=0;i<4;i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];
                int nb = node.broken;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                       if(!visited[nx][ny]){
                           if(map[nx][ny] == 1) {
                               queue.add(new Node(nx, ny, nb + 1));
                           } else {
                               queue.add(new Node(nx, ny, nb));
                           }
                       }
                        visited[nx][ny] = true;
                    }
            }
        }
    }


}