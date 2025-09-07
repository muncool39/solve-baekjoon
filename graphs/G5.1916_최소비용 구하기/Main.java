import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] head = new int[N + 1];
        Arrays.fill(head, -1);
        int[] to = new int[M];
        int[] w = new int[M];
        int[] next = new int[M];
        int idx = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            to[idx] = v;
            w[idx] = c;
            next[idx] = head[u];
            head[u] = idx++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0}); 

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (visited[u]) continue;
            visited[u] = true;
            if (u == goal) break;

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                int nd = d + w[e];
                if (dist[v] > nd) {
                    dist[v] = nd;
                    pq.add(new int[]{v, nd});
                }
            }
        }

        System.out.println(dist[goal]);
    }
}
