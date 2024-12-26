import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //항체 인식
    static int n,m;
    static int [][] before;
    static int [][] after;

    static int [] dw = {0,-1,0,1};
    static int [] dh = {1,0,-1,0};
    static int flag = 0;
    static String answer = "YES";

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        before = new int[n][m];
        after = new int[n][m];
        visited = new boolean[n][m];

        for (int i =0; i< 2*n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<m; j++){
                if(i < n){
                    before[i][j] = Integer.parseInt(st.nextToken());
                }else{
                    after[i-n][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i =0; i<n; i++){
            for(int j =0 ; j<m; j++){

                if(!visited[i][j] && before[i][j] != after[i][j] && flag == 0){ //같지 않으면 이제 dfs돌리기
                    flag = 1; //flag 1로 만들고 만약에 끝까지 flag가 0이면 yes
                    dfs(i,j,before[i][j], after[i][j]);
                }
            }
        }

        for(int i =0; i<n; i++){
            for(int j =0 ; j<m; j++){
                if(before[i][j] != after[i][j]){ //같지 않으면 이제 dfs돌리기
                    answer = "NO";
                    bw.write(answer);
                    bw.flush();
                    return; // "NO" 결정되면 즉시 종료
                }
            }
        }
        bw.write(answer);
        bw.flush();

    }

    private static void dfs(int x, int y, int originalValue, int targetValue) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (visited[x][y]) return;
        if (before[x][y] != originalValue) return;

        visited[x][y] = true;
        before[x][y] = targetValue;

        for(int i =0; i<4; i++){
            int nx = x+dw[i];
            int ny = y+dh[i];
            dfs(nx, ny, originalValue, targetValue);
        }
    }
}