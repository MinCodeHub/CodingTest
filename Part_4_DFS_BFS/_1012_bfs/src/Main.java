import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //1012번 - 유기농 배추 bfs로 풀기(X)
    static int M, N, K;
    static boolean[][] visited;
    static int[][] cabbage;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};


    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];

            visited[x][y] = true;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    if (cabbage[cx][cy] == 1 && !visited[cx][cy]) {
                        q.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    };


    public static void main(String[] args) throws IOException {

        //1012번 - 유기농 배추 bfs로 풀기(너비우선탐색)
        //bfs란...
        //큐에 넣었다가 빼서 그 주변을 다 둘러보는 너비 우선 탐색

        //테스트 케이스 개수 - T
        //배추 밭의 가로 길이 -M
        //배추 밭의 세로 길이 - N
        //배추가 심어져 있는 위치의 개수 - K

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            cabbage = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                String[] numbers = br.readLine().split(" ");
                int n1 = Integer.parseInt(numbers[0]);
                int n2 = Integer.parseInt(numbers[1]);
                cabbage[n1][n2] = 1;
            }
            //양배추 있는 곳에 cabbage 배열에 1을 넣어두고 없는 곳은 0임
            //1이 있는데 방문하지 않은 곳이면 dfs를 돌려라.

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }


}