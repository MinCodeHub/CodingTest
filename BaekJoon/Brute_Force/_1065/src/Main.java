import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //한수
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if(n < 100){
            cnt = n;
            System.out.println(cnt);
        }else{
            cnt = 99;
            for(int i =100; i <= n; i++){
                d(i);
            }

            System.out.println(cnt);
        }


    }

    //세자리 수 이상일 때에는 cnt 증가 시켜줘야함.
    private static void d(int number) {
       int hundred = number/100;
       int ten = (number/10)%10;
       int one = number% 10;

       if((hundred- ten) == (ten - one)) {
           cnt++;
       }
    }
}