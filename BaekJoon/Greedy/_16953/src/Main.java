import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //그리디
    //A->B

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        int cnt = 1;

        while(A!=B){
            if(B<A){
                System.out.println(-1);
                return;
            }

            if(B%10 ==1){ //맨 마지막 자리수가 1이면
                B/=10; //마지막 수인 1을 빼라.
            }
            else if(B%2 == 0){
                B/=2;
            }else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}