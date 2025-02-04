import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int x;

    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(br.readLine()); //원하는 순서
        cnt = 0; //순서 카운팅
        int t = 1;

        while (x != cnt) {
            if (t % 2 == 1) { //홀수라면
                for (int i = 0; i < t; i++) {
                    cnt += 1;
                    int n1 = t - i;
                    int n2 = i + 1;

                    if (cnt == x) {
                        System.out.println(n1 + "/" + n2);
                        break;
                    }
                }
            } else { //짝수라면
                for (int i = 0; i < t; i++) {
                    cnt += 1;
                    int n1 = i + 1;
                    int n2 = t - i;
                    if (cnt == x) {
                        System.out.println(n1 + "/" + n2);
                        break;
                    }
                }
            }
            t++;

        }
    }
}