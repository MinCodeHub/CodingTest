import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //특정 거리의 도시 찾기
    static int N, M, K, X;
    static Queue<Integer> q;
    static List<List<Integer>> graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); // 단방향 간선
        }

        distance = new int[N + 1]; //거리
        Arrays.fill(distance, -1);
        distance[X] = 0;

        q = new LinkedList<>();
        q.add(X);
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    q.add(next);
                }

            }
        }
        boolean found = false;

        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }

        }
        if (!found) {
            System.out.println(-1);
        }

    }
}