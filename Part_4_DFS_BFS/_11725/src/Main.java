import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    //트리의 부모 찾기 -> 첫번째 해결 방법: bfs 사용 // 부모를 찾아야해서 dfs로 다시 풀기
    //인접행렬 사용해서 메모리초과가 났음

    static int n; //노드의 개수
    static boolean []visited;

    static ArrayList<Integer>[] graph;
    static int []parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //초기화
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        parent = new int[n+1];

        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

           graph[n1].add(n2);
            graph[n2].add(n1);
        }
        dfs(1);

        for(int i = 2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for(int node: graph[start]){
            if(!visited[node]){
                parent[node] = start;
                dfs(node);
            }
        }
    }
}
