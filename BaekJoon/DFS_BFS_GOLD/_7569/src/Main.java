import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //토마토
    static int m,n,h;
    static int[][][] map; //박스 안에 있는 토마토 층 수도 나눠줘야하기 때문에 3차배열로 설정

    static int[] dx = {1, -1, 0, 0, 0, 0};  // 상하좌우 + 높이 변화를 위해 0 추가
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};  // 높이 위, 아래 이동

    static Queue<tomato> q = new LinkedList<>();

    static boolean flag = true;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st  = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];

        //맵 만들기
        for(int k = 0; k < h; k++){ //높이만큼
            for(int i = 0; i < n; i++){ //세로
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){ //가로
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int k = 0; k < h; k++) { //높이만큼
            for (int i = 0; i < n; i++) { //세로
                for (int j = 0; j < m; j++) { //가로
                    if (map[i][j][k] == 1) {
                        q.add(new tomato(i, j, k, 0));
                    }
                }
            }
        }

        bfs();

    }

    private static void bfs() {

        int day = 0;

        while(!q.isEmpty()){
            tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            int wh = t.h;
            day = t.day;
            //앞 뒤 왼 오 확인 하면서 위 아래도 확인하기
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = wh + dz[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h) {
                    if (map[nx][ny][nh] == 0) {
                        map[nx][ny][nh] = 1;
                        q.offer(new tomato(nx, ny, nh, day + 1));
                    }
                }
            }
        }

        for(int k = 0; k < h; k++){ //높이만큼
            for(int i = 0; i < n; i++){ //세로
                for(int j = 0; j < m; j++){ //가로
                    if(map[i][j][k] == 0){
                       flag = false;
                        //System.out.println("익지 않은 토마토 위치: (" + i + ", " + j + ", " + k + ")");
                    }
                }
            }
        }

        if(flag){
            System.out.println(day);

        }else{
            System.out.println(-1);
        }

    }

    static class tomato{
        int x;
        int y;
        int h;
        int day;

        public tomato(int x, int y, int h, int day){
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }
    }
}