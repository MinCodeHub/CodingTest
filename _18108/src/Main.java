import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       //18108번 - 1998년생인 내가 태국에서는 2541년생?!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sy = y - 543;
        bw.write(String.valueOf(sy));
        bw.close();
        br.close();
    }
}