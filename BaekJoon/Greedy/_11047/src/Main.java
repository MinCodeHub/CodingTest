import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] money;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        for (int j = N - 1; j >= 0; j--) {
            if (money[j] <= K) {
                int s = K / money[j];
                K = K - (s * money[j]);
                cnt += s;
                if(K == 0){
                    System.out.println(cnt);
                    break;
                }
            }else{
                continue;
            }
        }
    }
}