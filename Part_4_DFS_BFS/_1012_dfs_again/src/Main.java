import java.io.*;
import java.nio.Buffer;

public class Main {
    //1012번 - 유기농 배추 dfs로 다시 풀기(복습)
    static int[][] cabbage;
    static boolean[][] visited;
    static int count;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int M, N, K;

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int cx = x + dx[k];
            int cy = y + dy[k];
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (cabbage[cx][cy] == 1 && !visited[cx][cy]) {
                    dfs(cx, cy);
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        //유기농 배추 dfs로 다시 풀어보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;

            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            cabbage = new int[M][N]; //cabbage 초기화
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {

                String[] c = br.readLine().split(" ");
                int x = Integer.parseInt(c[0]);
                int y = Integer.parseInt(c[1]);

                cabbage[x][y] = 1; //양배추 있는 곳 1로 표시 없는 곳은 0임
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }


}