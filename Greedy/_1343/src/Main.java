import java.io.*;

public class Main {

    //1343번 폴리오미노

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String[] arr = str.split("\\.");

        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            int length = x.length();


            if (length % 2 != 0) {
                System.out.println("-1");
                return;
            }

            while (length >= 4) {
                sb.append("AAAA");
                length -= 4;
            }
            while (length >= 2) {
                sb.append("BB");
                length -= 2;
            }

            if (i != arr.length - 1) {
                sb.append(".");
            }
        }

        System.out.println(sb);
    }
}
