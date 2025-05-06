import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] mm = new int[n];
        for(int i = 0; i<n; i++){
            mm[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int min = mm[0];

        for(int i = 1; i < n; i++){
            answer = Math.max(answer, mm[i] - min);

            min = Math.min(min,mm[i]);
        }
        sb.append(answer);
        System.out.println(sb);
    }

}