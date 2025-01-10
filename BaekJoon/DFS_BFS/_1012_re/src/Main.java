import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //유기농 배추 bfs 복기
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static int cnt;

    static int m,n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());

             m = Integer.parseInt(st.nextToken());
             n = Integer.parseInt(st.nextToken());
             k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];
            cnt = 0;


            for(int j = 0 ;j < k; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;

            }

            for(int h =0; h<m; h++){
                for(int l = 0;l<n; l++){
                    if(map[h][l] == 1 && !visited[h][l]){
                        bfs(h,l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }




    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] current = q.poll();
            x = current[0];
            y = current[1];

            for(int i =0; i<4; i++){

                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cx < m && cy >= 0 && cy < n){
                    if(!visited[cx][cy] && map[cx][cy]==1){
                        q.add(new int[]{cx,cy});
                       visited[cx][cy] = true;  //visted true 안해주면 큐에 똑같은게 계속 들어갈 수 있음 -> 메모리 초과로 이어짐
                    }
                }
            }

        }


    }
}