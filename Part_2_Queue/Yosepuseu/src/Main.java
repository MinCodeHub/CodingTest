import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
      //  1. 1~N까지 Queue에 offer한다.

      //   2. K - 1 번째까지는 첫 번째 값을 맨 뒤로 보낸다.

      // 3. K번째 일때는 poll해서 출력한다.

      //  4. Queue의 사이즈가 1개일 때까지 반복한다. (Queue의 요소가 1개면 어차피 그것만 빼서 출력하면 되기 때문)

        Queue<Integer> q = new LinkedList<>();

        // Queue에 1~N까지 값을 offer한다.
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }


        StringBuilder sb = new StringBuilder();
        sb.append("<");


        while(q.size() !=1){
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로 보낸다.
            for(int i = 0; i < K -1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()+", ");
        }

        // Queue의 사이즈가 1일 때는 단순히 poll하면 된다.
        sb.append(q.poll() + ">");
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}