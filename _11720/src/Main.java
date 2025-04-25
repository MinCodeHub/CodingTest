import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine() ;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        System.out.println(sum);
    }
}