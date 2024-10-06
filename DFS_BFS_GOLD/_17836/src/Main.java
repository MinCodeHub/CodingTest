import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //17836 공주를 구해라
    static int n,m,t;
    static boolean[][][] visited; // 2차원 visited에 gram 여부 추가
    static int [][]graph;

    static int []dw = {-1,0,1,0};
    static int []dh = { 0,-1,0,1};
    static int min = Integer.MAX_VALUE;

    static Queue<Node> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        visited = new boolean[n + 1][m + 1][2]; // 그람을 주운 상태 0, 1로 구분
        //그람을 주웠을 때 방문 여부와, 그람을 안주웠을 때 방문여부를 다르게 가지고 가야함.

        for(int i =1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j< m+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(1,1);

        if( min <= t){
            System.out.println(min);
        }else{
            System.out.println("Fail");
        }


    }

    private static void bfs(int i, int j) {
        q = new LinkedList<>();
        q.offer(new Node(1,1,0,0));
        visited[1][1][0] = true; // (1,1) 방문, 그람 없음

        while(!q.isEmpty()){
            Node node = q.poll();
            int nx = node.x;
            int ny = node.y;
            int cnt = node.cnt;
            int g = node.gram;

            if(nx == n && ny == m){
                min = Math.min(min, cnt);
            }

            for(int k = 0; k < 4; k++){
                    int n1 = nx + dw[k];
                    int n2 = ny + dh[k];


                    if(n1 > 0 && n1 <=n && n2 > 0 && n2 <= m ){

                        if(g == 1) {//그람을 가지고 있음. -> 그람이 부쉴 수 있는 벽의 개수는 무한임.
                            if(!visited[n1][n2][1]) {
                                q.offer(new Node(n1, n2, cnt + 1, 1));
                                visited[n1][n2][1] = true;
                            }
                        }
                        if(!visited[n1][n2][0]){ //그람이 없는 경우
                            if(graph[n1][n2] == 0){
                                q.offer(new Node(n1, n2, cnt + 1, 0));
                                visited[n1][n2][0] = true;
                            }else if(graph[n1][n2] == 2){
                                q.offer(new Node(n1, n2, cnt + 1, 1));
                                visited[n1][n2][1] = true;
                            }

                        }
                    }
            }
        }

    }

    static class Node{
        int x;
        int y;
        int cnt;
        int gram;
        Node(int x, int y, int cnt, int gram){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }
    }



}