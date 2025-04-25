import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //조합 -> 중복 조합
    static int N;
    static int num[];

    static List<Integer> list;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[]{1, 5, 10, 50};
        result = new int[N];
        list = new ArrayList<>();
        comb(0, 0);
        System.out.println(list.size());
    }

    private static void comb(int start, int depth) {

        if (depth == N) {
            int sum = 0;
            for (int n : result) {
                sum += n;
            }

            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            result[depth] = num[i];
            comb(i, depth + 1);
        }
    }
}

