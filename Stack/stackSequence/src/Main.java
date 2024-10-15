import java.io.*;
import java.util.Stack;

public class Main {


    //백준 1874번 스택 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();    // 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();
        int count = 1;
        int[] seq;

        int N = Integer.parseInt(br.readLine());
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        //배열 첫번째 수 까지 push
        for (int i = count; i <= seq[0]; i++) {
            stack.push(count);
            sb.append('+').append('\n');
            count++;
        }
        stack.pop();
        sb.append('-').append('\n');

        //count 가 N이 되었다는 것은 1부터 N까지의 수를 스택에 다 넣었다는 의미
        for (int j = 1; j < seq.length; j++) {
            // 순열 배열이 stack.peek과 같으면 pop하고
            // 아니면 해당 위치 순열 배열의 수까지 push하고 pop해라.
            if (!stack.isEmpty() && seq[j] == stack.peek()) {
                stack.pop();
                sb.append('-').append('\n');
            } else if (!stack.isEmpty() && seq[j] < stack.peek()) {
                System.out.println("NO");

                return;
            } else {
                while (count <= seq[j]) {
                    stack.push(count);
                    sb.append('+').append('\n');
                    count++;
                }
                stack.pop();
                sb.append('-').append('\n');
            }
        }
        System.out.println(sb);
    }

}