import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.IntBuffer;
import java.util.StringTokenizer;

public class Main {

    static int map[][];
    static boolean visitied[][];

    static int N;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j],max);
            }
        }
        int tempMax = 0;
        for (int height = 0; height <= max; height++) {
            visitied = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visitied[i][j] && map[i][j] > height ){
                        count += dfs(i,j,height);
                    }
                }
            }
            tempMax = Math.max(tempMax,count);
        }
        System.out.println(tempMax);
    }

    static int dfs(int x,int y,int height){
        visitied[x][y] = true;

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visitied[nx][ny]) continue;
            if (map[nx][ny] > height) dfs(nx,ny,height);
        }
        return 1;

    }
}