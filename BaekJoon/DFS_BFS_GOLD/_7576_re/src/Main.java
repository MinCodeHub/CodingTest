import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //토마토
    static int[] dx={-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static int m, n;
    static int[][] map;
    static Queue<tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m  = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                   queue.offer(new tomato(i,j,0));
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        int day = 0;
        while(!queue.isEmpty()){
            tomato t = queue.poll();

            int x = t.x;
            int y = t.y;

            day = t.day;

            for(int i = 0; i < 4; i++){
                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(map[nx][ny]==0){
                        map[nx][ny]=1;
                        queue.offer(new tomato(nx,ny,day+1));
                    }
                }
            }
        }

        if(checkTomato()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }

    }

    private static boolean checkTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }

    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}