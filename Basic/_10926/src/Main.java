import java.io.*;

public class Main {
    //백준 10926번
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(str+"??!");

        br.close();
        bw.close();

    }
}