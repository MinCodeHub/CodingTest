import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    //조합 + 백트래킹
    static int N,M;
    static int[] output;
    static int[] num;
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        output = new int[M];
        isVisited = new boolean[N];

        for(int i=0; i<N;i++){
            num[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        comb(0,0);
        System.out.println(sb);

    }

    private static void comb(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1; // 이전에 선택한 값

        for (int i = start; i < N; i++) {
            if (before == num[i]) continue; // 이전 값과 같으면 중복이므로 건너뛰기

            before = num[i];  // 현재 값을 이전 값으로 업데이트
            output[depth] = num[i];
            comb(i + 1, depth + 1);  // 다음 인덱스부터 탐색 (중복 방지)
        }
    }
}
