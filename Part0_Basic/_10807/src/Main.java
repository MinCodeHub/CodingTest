import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //10807번 - 개수 세기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");


        int findNumber = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(input[i]) == findNumber) {
                count += 1;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}