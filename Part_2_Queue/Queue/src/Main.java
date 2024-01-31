import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //10845번 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<Integer>();
        int last = 0;
        //last는 back이 입력 되었을때 마지막 인덱스에 저장된 값을 출력하기위한 변수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            switch (s) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.offer(last);
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        sb.append(q.poll());
                        sb.append("\n");
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;

                case "size":
                    if (!q.isEmpty()) {
                        sb.append(q.size());
                        sb.append("\n");
                    } else {
                        sb.append(0);
                        sb.append("\n");
                    }
                    break;
                case "empty":
                    if (!q.isEmpty()) {
                        sb.append(0);
                        sb.append("\n");
                    } else {
                        sb.append(1);
                        sb.append("\n");
                    }
                    break;

                case "front":
                    if (!q.isEmpty()) {
                        sb.append(q.peek());
                        sb.append("\n");
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;

                case "back":
                    if (!q.isEmpty()) {
                        sb.append(last);
                        sb.append("\n");
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}