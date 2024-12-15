import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //2468번 안전 영역
    static int arr[][];
    static int visit[][];
    static int number = 0;
    static int max = 0;
    static int N;
    static int nowX, nowY;
    static int[] dicX = {-1, 1, 0, 0};
    static int[] dicY = {0, 0, -1, 1};
    static int maxHeight = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new int[N][N];

        //배열 생성

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] parts = str.split(" "); // 공백을 기준으로 문자열을 나누기
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(parts[j]);
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }
        max = 0;
        for (int h = 0; h <= maxHeight; h++) { //높이 1부터 시작
            visit = new int[N][N];

            if (max <= number) {
                max = number;
            }
            else {
                break;
            }
            number = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > h && visit[i][j] == 0) { //높이보다 크고 방문하지 않은 곳 탐색(잠기지 않은 곳을 찾아야하니까 조건을 반대로)
                        number++;
                        visit[i][j] = number;
                        dfs(i, j, h); //dfs호출
                    }
                }
            }
        }
        System.out.println(max);

    }

    static void dfs(int x, int y, int h) {
        visit[x][y] = number;

        for (int i = 0; i < 4; i++) {
            nowX = dicX[i] + x;
            nowY = dicY[i] + y;

            if (checkarr() && arr[nowX][nowY] > h && visit[nowX][nowY] == 0) {
                //높이보다 크고 방문하지 않은 곳 탐색(잠기지 않은 곳을 찾아야하니까 조건을 반대로)
                dfs(nowX, nowY, h); //dfs호출
            }
        }

    }

    static boolean checkarr() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    }
}