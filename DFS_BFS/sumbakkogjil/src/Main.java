import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//참고 https://smartpro.tistory.com/18

public class Main {
    //백준 1697번 숨박꼭질
    //BFS 너비 탐색
    static int start;
    static int end;
    static int visited[] = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        //수빈 위치
        start = Integer.parseInt(st.nextToken());
        //동생 위치
        end = Integer.parseInt(st.nextToken());
        int result = bfs(start);
        System.out.println(result);

    }

    private static int bfs(int node) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;


        while (queue.isEmpty() == false) {
            n = queue.remove();

            if (n == end) {
                return visited[n] - 1;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }

            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n] + 1;
                queue.add(2 * n);
            }
        }
        return -1;
    }
}