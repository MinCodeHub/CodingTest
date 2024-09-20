import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 쉬운 최단거리
 * BFS
 * 2인 지점부터 bfs로 돌리고, visited 배열로 방문 여부
 *
 * */
public class Main {

    static int n,m;
    static boolean [][]visited;
    static int [][]count;
    static int n1,n2;
    static int []dh ={-1,0,1,0};
    static int []dw = {0,1,0,-1};

    static int [][]graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1][m+1];
        graph = new int[n+1][m+1];
        count = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if(graph[i][j] == 2){
                        n1 = i;
                        n2 = j;
                    }
            }
        }

        bfs(n1,n2);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(!visited[i][j] && graph[i][j] ==1){
                    //방문한 적은 없고, 그래프는 1일 때 -> 갈 수 없는 곳 -1 출력
                    System.out.print(-1 + " ");
                }else{
                    System.out.print(count[i][j]+ " ");
                }
            }
            System.out.println();
        }

    }

    //큐에다가 n1,n2모두 넣고 n1,n2에서 하나 더하기.
    private static void bfs(int n1, int n2) {

     Queue<Point> queue = new LinkedList<>();
        visited[n1][n2] = true;
        queue.add(new Point(n1,n2));

        while(!queue.isEmpty()){
            Point p =  queue.poll();
            int t1 = p.x;
            int t2 = p.y;

            for(int i = 0; i < 4; i++){
                int temp1 = dw[i]+t1;
                int temp2 = dh[i]+t2;
                if(temp1>0 && temp2>0 && temp1 <= n && temp2 <= m){
                    if(!visited[temp1][temp2] && graph[temp1][temp2] == 1){
                        visited[temp1][temp2] = true;
                        count[temp1][temp2] = count[t1][t2]+1;
                        queue.add(new Point(temp1,temp2));
                    }
                }
            }
        }

    }
    private static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}