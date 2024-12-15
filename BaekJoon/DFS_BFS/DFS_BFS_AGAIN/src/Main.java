import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    //1260번 - DFS 와 BFS 다시 복습
    //방문 여부 배열
    static boolean[] visited;
    //그래프 선언
    static ArrayList<ArrayList<Integer>> graph; //어레이리스트 안에 또 어레이리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String[] input = br.readLine().split(" ");
        graph = new ArrayList<>();
        //정점의 개수, 간선의 개수, 시작정점 입력할 것임

        //정점의 개수만큼 visited배열 초기화
        int v = Integer.parseInt(input[0]);
        visited = new boolean[v + 1]; //정점이 1부터이기 떄문에 1을 더 더해준다.

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>()); //그래프 초기화
        }

        //무방향 그래프 코드
        //간선 개수
        int en = Integer.parseInt(input[1]);

        for (int i = 0; i < en; i++) {
            String[] n = br.readLine().split(" ");
            int n1 = Integer.parseInt(n[0]);
            int n2 = Integer.parseInt(n[1]);

            graph.get(n1).add(n2); //n1인덱스에 n2추가 -> 서로 연결되어있으니까.
            graph.get(n2).add(n1); //위와 동일

        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i)); //link[i] 줄 정렬
        }

        int start = Integer.parseInt(input[2]);

        dfs(start);
        System.out.println();
        visited = new boolean[v + 1]; //초기화를 또 해줘야함
        System.out.println(bfs(start, graph, visited));
    }


    //깊이 우선 탐색
    private static void dfs(int nodeIndex) {

        visited[nodeIndex] = true; //시작 구간은 방문했다고 표시
        System.out.print(nodeIndex + " ");

        for (int node : graph.get(nodeIndex)) {
            if (!visited[node]) {
                //시작 노드와 연결된 노드들 중에 방문한 적 없는 노드라면
                dfs(node); //dfs 호출
            }
        }
    }

    //너비 우선 탐색 - queue
    private static String bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {

        //탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();

        //BFS에 사용할 큐를 생성
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);

        visited[start] = true;

        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " ");

            for (int node : graph.get(nodeIndex)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }
        return sb.toString();
    }


}