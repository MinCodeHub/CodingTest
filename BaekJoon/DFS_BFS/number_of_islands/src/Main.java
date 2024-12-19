import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 대각선
    static int dirY[] = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 대각선
    static int w,h, nowX,nowY;


    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        String str = " ";

        while(!(str = br.readLine()).equals("0 0")){
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<w; j++ ){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island_cnt = 0;

            for(int i =0; i<h;i++){
                for(int j = 0; j<w; j++){
                    if(!visit[i][j] && arr[i][j] ==1){
                        island_cnt++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(island_cnt).append("\n");

        }
        System.out.println(sb);

    }

    private static void dfs(int x, int y) {

        visit[x][y] = true;

        for(int i =0; i < 8; i++){
            nowX = x+dirX[i];
            nowY = y + dirY[i];
            if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1){
                dfs(nowX, nowY);
            }
        }
    }
    static boolean range_check() {
        return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
    }
}

