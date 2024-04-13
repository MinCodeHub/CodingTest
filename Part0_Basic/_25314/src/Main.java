import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    //25314번 - 코딩은 체육과목 입니다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N / 4; i++){
            bw.write("long ");
        }
        bw.write("int");

        br.close();
        bw.close();
    }
}