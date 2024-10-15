import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//11382번-꼬마 정민
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        long A =    Long.parseLong(input[0]);
        long B =    Long.parseLong(input[1]);
        long C =    Long.parseLong(input[2]);

        long total = A+B+C;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(total));
        bw.close();
        br.close();
    }
}

//런타임에러(NumberFormat) - int를 사용해서
//받는 숫자가 int보다 큰 값을 출력하므로 long형(8byte)를 사용하여 출력해야 한다.

