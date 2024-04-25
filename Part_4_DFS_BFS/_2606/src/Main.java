import java.io.*;
import java.util.ArrayList;

public class Main {
    //2606번 - 바이러스
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //정점 수
        int v = Integer.parseInt(br.readLine());

        //간선의 수
        int e = Integer.parseInt(br.readLine());

        //visted방문 초기화
        visited = new boolean[v + 1];

        //그래프 초기화
        graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
        }

        //그래프에 값 넣기
        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int start = 1;
        int c = dfs(start);
        System.out.println(c);
    }

    private static int dfs(int start) {

        visited[start] = true;
        count++;
        //방문한 적이 없으면
        for (int node : graph.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
        return count - 1;
    }


}