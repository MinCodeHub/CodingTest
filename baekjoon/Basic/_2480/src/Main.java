import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //2480번 - 주사위 세개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        int max = A;
        int prize = 1;

        if (A == B && A == C && B == C) { //3개가 모두 같으면
            prize = 10000 + A * 1000;

        } else if (A == C) { //2개만 같을 때
            prize = 1000 + A * 100;

        } else if (B == C) {
            prize = 1000 + B * 100;

        } else if (A == B) {
            prize = 1000 + B * 100;

        } else {
            if (max < B) {
                max = B;
            }
            if (max < C) {
                max = C;
            }
            prize = max * 100;

        }
        bw.write(String.valueOf(prize));
        bw.close();
        br.close();
    }
}