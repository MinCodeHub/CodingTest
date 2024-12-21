import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //영역 구하기
    static int M,N,K;
    static boolean [][]visited;
    static int[] dw={-1, 0, 1, 0};
    static int[] dh = {0, 1, 0, -1};
    static int answer;
    static int size;
    static List<Integer> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        answer = 0;

        //직사각형 개수만큼 돌린다.

        for(int i =0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int j = lx; j < rx; j++){
                for(int k = ly; k < ry; k++){
                    if(!visited[j][k]){
                        visited[j][k] = true;
                    }
                }
            }
        }


//        //dfs로 카운트 시작
        for(int  h = 0; h<N; h++){
            for(int g = 0; g<M;g++){
                if(!visited[h][g]){
                    answer++;
                    size = 1;
                    dfs(h, g); // DFS 호출 후 영역 크기를 얻음
                    areas.add(size);
                }
            }
        }

        Collections.sort(areas);
        System.out.println(answer);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i =0; i<4; i++){
            int nx = x+ dw[i];
            int ny = y + dh[i];

            if(nx>=0 && nx<N && ny >= 0 && ny <M){
                if(!visited[nx][ny]){
                    size++;
                    dfs(nx,ny);
                }
            }

        }
    }
}