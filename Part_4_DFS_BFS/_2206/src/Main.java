import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    static int minsize = Integer.MAX_VALUE;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //2206 - 벽 부수고 이동하기 - 시간초과

        //n,m까지 가는데 최단거리 구하기
        //시작하는 칸과 끝나는 칸도 포함해서 셈.
        // 만약에 이동하는 도중에 한개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한개까지 부수도 이동해도 됨.


        //1. 벽은 부수지 않고 이동한 경우
        //2. 벽을 한개 부수고 이동한 모든 경우
        //3. 벽을 부술 때는 dfs + 백트래킹
        //4. 이동할 경우는 bfs -> 시간 초과 남



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;


        bfs();

        visited = new boolean[n][m];

        //벽 하나 부시고 최단경로 구하는 방법

        dfs(0);


        if (minsize == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minsize);
        }
    }

    private static void dfs(int brokenwall) {
        if (brokenwall == 0) {
            queue.add(new Node(0, 0, 1));
            visited = new boolean[n][m];
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    dfs(brokenwall - 1);
                    map[i][j] = 1;
                }
            }
        }

    }

    private static void bfs() {
        int rootcnt = 0;
        int nx = 0;
        int ny = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            rootcnt = node.c;
            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, rootcnt + 1));
                    }
                }
            }
        }
        if (nx == n && ny == m - 1) {
            if (minsize > rootcnt) {
                minsize = rootcnt;
            }
        }

        //System.out.println("벽안세우고 경로: " + rootcnt);
    }


    static class Node {
        int x;
        int y;
        int c;

        int getC() {
            return c;
        }

        Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}