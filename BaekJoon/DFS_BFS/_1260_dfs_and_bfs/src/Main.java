import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,v;
    static int [][] graph;
    static boolean []visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //1260 dfs와 bfs

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new int[n+1][n+1];

        //방문여부 배열 초기화
        visited = new boolean[n+1];

        //그래프 만들기 (양방향)
        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;

        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);

    }

    private static void dfs(int start) {

        visited[start] = true;
        sb.append(start).append(" ");
        for(int i = 0; i<=n; i++){
            if(graph[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    //bfs 너비우선 탐색 (큐, 링크드리스트)
    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");


            for(int i =1; i <= n ; i++){
                if(graph[temp][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


}