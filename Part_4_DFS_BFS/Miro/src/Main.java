import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //백준 2178번 미로
    static boolean visited[][];
    static int arr[][];

    static int  N, M;
    static int dicX[] = {-1, 1, 0, 0}; //상하
    static int dicY[] = {0, 0, -1, 1}; //좌우

    static int number = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
       visited[0][0] = true;
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

    }



    static void bfs(int x, int y) {
      Queue<int[]>q = new LinkedList<>();
      q.add(new int[] {x,y});

      while(!q.isEmpty()){
          int now[] = q.poll();
          int nowx = now[0];
          int nowy = now[1];

          for(int i = 0; i<4; i++){
              int nextX = nowx+dicX[i];
              int nextY = nowy+ dicY[i];

              if(nextX < 0|| nextY < 0 || nextX >= N || nextY >= M)
                  continue;
              if(visited[nextX][nextY] || arr[nextX][nextY]==0)
                  continue;

              q.add(new int[] {nextX,nextY});
              arr[nextX][nextY] = arr[nowx][nowy]+1;
              visited[nextX][nextY] = true;
          }

      }
    }
}