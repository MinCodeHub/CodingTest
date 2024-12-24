import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static boolean[][] visited;
    static int[][] map;
    static int cnt; //그림의 개수
    static int max = 0; //가장 넓은 그림의 넓이
    static int[] dw ={-1,0,1,0};
    static int[] dh= {0,-1,0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] ==1) {
                    int area = dfs(i, j); // 그림의 넓이 계산
                    if(area  > max){
                        max = area ;
                    }
                    cnt++;
                }

            }
        }


        System.out.println(cnt);
        System.out.println(max);

    }

    private static int dfs(int x, int y) {

        visited[x][y] = true;
        int area = 1;

        for(int i =0;i<4; i++){
            int nx = dw[i] + x;
            int ny = dh[i] + y;
            if(nx < n && nx>=0 && ny <m && ny >=0){
                if(!visited[nx][ny] && map[nx][ny] == 1 ){
                    area += dfs(nx, ny);  // 연결된 칸을 재귀적으로 탐색하여 넓이 증가
                }

            }
        }
        return area;
    }
}