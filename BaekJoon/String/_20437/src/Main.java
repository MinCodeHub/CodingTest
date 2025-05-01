import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String w;
    public static void main(String[] args) throws IOException {

        int t = 0;
        int k = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            w = br.readLine();
            k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26]; //알파벳 별 개수를 저장
            for (int j = 0; j < w.length(); j++) {
                alpha[w.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < w.length(); j++) {
                if (alpha[w.charAt(j) - 'a'] < k) {
                    continue;
                }

                int cnt = 1;

                for (int l = j + 1; l < w.length(); l++) {
                    if (w.charAt(j) == w.charAt(l)) {
                        cnt++;
                    }

                    if (cnt == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}