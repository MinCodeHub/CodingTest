import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {

        //1260번 - DFS 와 BFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        graph = new ArrayList<>();

        //인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
        int vn = Integer.parseInt(st.nextToken());
        visited = new boolean[vn + 1];

        for (int i = 0; i <= vn; i++) {
            graph.add(new ArrayList<>());
        }
        //무방향 그래프 코드
        int en = Integer.parseInt(st.nextToken());

        for (int i = 0; i < en; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        // 자식이 여러 개일 때, 번호가 작은 것부터 방문하기 때문에 오름차순 정렬
        //자바 Collections.sort

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i)); // link[i] 줄을 정렬
        }
        //그래프 출력 test
//        for(int i = 1; i <= 4; i++){
//            bw.write(graph.get(i).toString());
//        }
//        bw.flush();
//        bw.close();
        int start = Integer.parseInt(st.nextToken());
        dfs(start);
        System.out.println();
        visited = new boolean[vn + 1];
        System.out.println(bfs(start, graph, visited));
    }

    //dfs 재귀 코드
    static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;
        System.out.print(nodeIndex + " ");

        for (int node : graph.get(nodeIndex)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static String bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        // 탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();
        // BFS에 사용할 큐를 생성해줍니다.
        Queue<Integer> q = new LinkedList<Integer>();

        // 큐에 BFS를 시작 할 노드 번호를 넣어줍니다.
        q.offer(start);

        // 시작노드 방문처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " ");
            //큐에서 꺼낸 노드와 연결된 노드들 체크
            for (int node : graph.get(nodeIndex)) {
                // 방문하지 않았으면 방문처리 후 큐에 넣기
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }
        // 탐색순서 리턴
        return sb.toString();
    }
}