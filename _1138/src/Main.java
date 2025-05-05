import java.io.*;
import java.util.*;

class Main {
    public static final int BLANK = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        Arrays.fill(line, BLANK);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tall = 0; tall < N; tall++) {
            int leftCount = Integer.parseInt(st.nextToken());

            //tall은 나중의 값이 현재 값보다 무조건 큼
            //현재 시점의 leftCount는 큰 수가 와야하는 공간의 개수를 의미
            //따라서 빈 위치일 때만 count를 증가시킨다.
            //만약 count가 leftCount와 같아진다면, 해당 자리가 tall을 삽입한다.
            int count = 0;
            for (int i = 0; i < N; i++) {
                if(line[i]==BLANK) {
                    if (count == leftCount) {
                        line[i] = tall + 1;
                        break;
                    }

                    count++;
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}