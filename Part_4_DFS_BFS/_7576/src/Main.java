import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    //7576번 - 토마토

    //dfs로 풀다가 bfs로 변경

    static int[][] box;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int M, N;
    static Queue<tomato> queue = new LinkedList<tomato>();

    static class tomato {
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static void bfs() {

        int day = 0;
        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {

                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, day + 1));
                    }
                }
            }
        }
        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);


        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] istomato = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(istomato[j]);
                if (box[i][j] == 1) {
                    //만약 토마토가 들어있다면
                    queue.offer(new tomato(i, j, 0));
                }
            }
        }
        bfs();
    }
}