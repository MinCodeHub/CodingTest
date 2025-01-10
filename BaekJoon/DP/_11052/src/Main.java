import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //카드 구매하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] card = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i =1; i<=n; i++){
            card[i]  = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int j = 1; j<n+1; j++){
            for(int i = 1; i < j + 1; i++){
                dp[j] = Math.max(dp[j],dp[j-i]+ card[i]);
            }
        }

        System.out.println(dp[n]);

    }
}