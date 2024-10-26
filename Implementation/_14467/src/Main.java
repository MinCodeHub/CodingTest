import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //14467 소가 길을 건너간 이유 1
    static int n;
    static int[] cow;
    static boolean[] isfirst;

    static int result;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        result  = 0;

        cow = new int[n + 1]; //0으로 모두 초기화
        isfirst = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int cownum = Integer.parseInt(st.nextToken());
            int side = Integer.parseInt(st.nextToken());

            //만약 처음일 때
            if(!isfirst[cownum]){
                cow[cownum] = side;
                isfirst[cownum] = true;
            }else {
                if (cow[cownum] != side) {
                    cow[cownum] = side;
                    result++;
                }
            }
        }

        System.out.println(result);


    }
}