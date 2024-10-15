import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //미로탐색

    static int []dx = {-1,0,1,0};
    static int []dy = {0,-1,0,1};
    static char [][]graph;
    static boolean [][]visited;
    static int n,m;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0;j < m; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        bfs(0,0);

        System.out.println();


    }

    private static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new Point(x, y, 1));
        visited[x][y] = true;

        while(!queue.isEmpty()){

            Point p = queue.poll();
            int nx = p.x;
            int ny = p.y;
            int cnt = p.count;

            if(nx == n-1 && ny ==m-1){
                System.out.println(cnt);
                return;
            }

            for(int i = 0; i< 4; i++){
                int nx1 = nx + dx[i];
                int ny2 = ny + dy[i];

                if(nx1 >= 0 && nx1 < n && ny2>=0 && ny2<m){
                    if(graph[nx1][ny2] == '1'){
                        if(!visited[nx1][ny2]){
                            visited[nx1][ny2] = true;
                            queue.add(new Point(nx1,ny2,cnt+1));
                        }
                    }
                }


            }
        }
    }

    static class Point{
        int x;
        int y;
        int count;

        Point(int x, int y, int cnt){
           this.x = x;
           this.y = y;
           this.count = cnt;
        }

    }
}