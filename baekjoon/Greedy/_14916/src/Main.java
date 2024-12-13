import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //14916 - 거스름돈
    static int N,M;
    static int result;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = 0;
        int count = 0;
        int temp = 0;

        while(true){
            if(N%5 == 0){
                count+=N/5;
                System.out.println(count);
                break;
            }else{
                N-=2;
                count++;
            }
            if(N < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}