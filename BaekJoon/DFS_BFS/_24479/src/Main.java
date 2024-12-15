import java.io.*;
import java.util.*;

public class Main {
    static int n; //정점의 수
    static int m; //간선의 수
    static int r; //시작 정점

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int[] visited;
    static int cnt; //순서 세기

    public static void main(String[] args) throws IOException {
        //알고리즘 수업 - 깊이 우선 탐색1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        for (int k = 0; k <= n; k++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];
//        ordernum = new int[n + 1]; //출력
        cnt = 1;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //오름차순 정렬
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        dfs(r);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {

        visited[start] = cnt;

        for (int k : graph.get(start)) {
            if (visited[k] == 0) { //방문한 적 없으면
                cnt++;
                dfs(k);
            }
        }


    }
}