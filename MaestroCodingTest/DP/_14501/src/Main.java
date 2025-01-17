import java.io.*;
import java.util.*;

public class Main {
    //퇴사 -> top-down 방식 -> 꼭 다시 풀어보기.
    static int n;;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        info = new int[n+1][2];

        for(int i = n ; i > 0; i--){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); //걸리는 상담 시간
            info[i][1] = Integer.parseInt(st.nextToken()); //상담이 끝나면 받게되는 돈.
        }

//        for(int i = 1 ; i <= n; i++){
//            System.out.println( info[i][0]+" "+ info[i][1]);
//        }


        int[] dp = new int[n+1];
        //info[1][0] -> 마지막 날에 잡는 상담의 상담시간.

        //dp[1] = 남은 상담 시간 -> 퇴사 전까지 하루 남음.
        //dp[2] = 퇴사 전까지 이틀 남음.
        dp[0] = 0;

        for(int j = 1; j <= n; j++){
            if(info[j][0] > j){ //상담 시간이 남은 시간보다 크니까 상담 진행 못함.
                dp[j] = dp[j-1];
            }else{ //상담을 할 수 있을 때
                //상담을 안하고 넘어갈 때랑, 상담 할때랑 누가 더 큰지 비교
                dp[j] = Math.max(dp[j-1], info[j][1]+dp[j-info[j][0]]);
            }
        }

        System.out.println(dp[n]);



    }
}
