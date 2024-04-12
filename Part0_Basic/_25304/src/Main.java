import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //25304번 - 영수증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());

        Long total = 0L; //전체 합

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Long price = Long.parseLong(input[0]);
            int number = Integer.parseInt(input[1]);
            total += price * number;
        }

        if (total.equals(X)) {  //자바에서는 -128에서 127까지의 범위의 상수풀을 유지한다.
            //따라서 ==을 통해 비교하더라도 정상적으로 동작할 수 있다.
            //하지만 더 큰 값으로 올라가는 경우 정상적으로 동작하지 않을 수 있기에 equals를 사용해 비교해야한다.
            bw.write("Yes");
        } else {
            bw.write("No");
        }

        br.close();
        bw.close();

    }
}