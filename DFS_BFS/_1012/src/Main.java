import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //1012번 - 유기농 배추 dfs로 풀기(X)

    static int M, N, K;
    static boolean[][] visited;
    static int[][] cabbage;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            //상하좌우를 둘러보면서 방문한 적이 없는데 1이 있다면 그 중심으로 dfs 다시 돌리기
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (!visited[cx][cy] && cabbage[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

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
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }


}