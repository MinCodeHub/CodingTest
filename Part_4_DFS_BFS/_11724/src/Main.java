import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //11724번 - 연결 요소의 개수
    static ArrayList<ArrayList<Integer>> graph;

    static boolean[] visited;
    static int N, M, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        for (int k = 0; k <= N; k++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        count = 0;

        for (int i = 0; i < M; i++) {
            String[] uv = br.readLine().split(" ");
            int n1 = Integer.parseInt(uv[0]);
            int n2 = Integer.parseInt(uv[1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

            for(int l = 1; l <= N;l++){
                if(!visited[l]){
                    dfs(l);
                    count++;
                }
            }
            System.out.print(count);
    }

    private static void dfs(int l) {

        visited[l] = true;


        for(int k = 0; k < graph.get(l).size(); k++){
            int idx = graph.get(l).get(k);
            if(!visited[idx]){
                dfs(idx);
            }
        }
    }
}