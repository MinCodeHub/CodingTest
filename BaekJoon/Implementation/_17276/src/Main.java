import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//실버 1
//한번에 바꿔주지 않았다는 점과
//r = ((r % 360) + 360) % 360; // 음수도 양수로 변환
//            r /= 45;
//이부분과
//tmp 깊은 복사해야하는데 얕은 복사해서
//구현방식은 잘 했는데 디테일한 부분에서 틀렸음... 코드 작성까진 35분 정도 걸렸는데 틀렸고,,,, 맞았습니다 나오기까지 1시간정도 걸렸다..
public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    static int[][] tmp;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i< t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            map = new int[n + 1][n + 1];
            tmp = new int[n + 1][n + 1];

            for(int j = 1; j<=n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 1; k<=n; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                    tmp[j][k] = map[j][k];
                }
            }

            r = ((r % 360) + 360) % 360; // 음수도 양수로 변환
            r /= 45;

            for(int l = 0; l<r;l++){
                circleX();
            }

            for(int p = 1; p<=n;p++){
                for(int j = 1; j<=n; j++){
                    sb.append(map[p][j]).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.print(sb);
    }

    private static void circleX() {
        //값을 미리 저장하고 한번에 옮겨야한다... 메모..
        for (int i = 1; i <= n; i++) {  //주 대각선을 가운데로 옮김
            tmp[i][((n + 1) / 2)] = map[i][i];
            tmp[n+1-i][i] = map[n+1-i][((n + 1) / 2)];
            tmp[((n + 1) / 2)][i] = map[n + 1 - i][i];
            tmp[i][i] = map[((n + 1) / 2)][i];
        }
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j<=n; j++){
                map[i][j] = tmp[i][j];
            }
        }

    }
}