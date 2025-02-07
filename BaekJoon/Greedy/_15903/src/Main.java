import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //카드 합체 놀이 -> 우선 순위 큐
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //기본형 : 우선 순위가 낮은 숫자가 먼저 나옴
        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i = 0; i<N; i++){
            q.offer(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i < M; i++){
            long n1 = q.poll();
            long n2 = q.poll();
            long sum = n1+n2;

            q.offer(sum);
            q.offer(sum);
        }
        long result = 0;

        while(!q.isEmpty()){
            result += q.poll();
        }
        System.out.println(result);
    }

}
