import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] distance;
    static int[] cost;
    //그리디 -> 가격이 쌀 때 기름을 채워 넣어야함.
    //그러면? 내림차순일 때만 가격 갱신!

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        distance = new int[N-1];
        cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i < N - 1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j =0; j < N ; j++){
            cost[j] = Integer.parseInt(st.nextToken());
        }


        long sum = 0;
        long minCost = cost[0];


        for(int i = 0; i<N-1; i++){
            //현재 주유소가 이전 주유소의 기름값보다 쌀 경우
            //minCost 갱신
            if(cost[i] < minCost){
                minCost = cost[i];
            }

            sum+= minCost * distance[i];

        }

        System.out.println(sum);

    }

}