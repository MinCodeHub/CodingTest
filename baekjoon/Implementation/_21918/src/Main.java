import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //21918번 - 전구
    static int N, M;
    static int[] volt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        volt = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            volt[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1 :
                    volt[b - 1] = c;
                    break;
                case 2 :
                    for (int i = b - 1; i <= c - 1; i++) {
                        if (volt[i] == 1) {
                            volt[i] = 0;
                        } else {
                            volt[i] = 1;
                        }
                    }
                    break;
                case 3 :
                    for (int i = b - 1; i <= c - 1; i++) {
                        volt[i] = 0;
                    }
                    break;
                case 4 :
                    for (int i = b - 1; i <= c - 1; i++) {
                        volt[i] = 1;
                    }
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(volt[i] + " ");
        }
    }
}