import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    //양방향 리스트
    //색칠하기
    static int n,m;
    static boolean[] visited; //0이면 방문 안한거고, 1과 2는 색깔 칠한 것. 기본이 1
    static int t; //테스트 케이스
    static ArrayList<ArrayList<Integer>> arr;

    static int[] color;
    static StringBuilder sb = new StringBuilder();

    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        //테스트 케이스 수만큼 초기화
//        arr = new int[t];
//
        for(int i =0; i < t; i++){

            arr = new ArrayList<>();

            flag = true;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= n; j++) {
                arr.add(new ArrayList<>()); // Initialize adjacency list for each node
            }

            visited = new boolean[n+1]; //방문 배열 초기화
            color = new int[n+1]; //색 배열 초기화

            for(int j = 1; j <= m; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr.get(x).add(y);
                arr.get(y).add(x); //양방향으로 값을 넣는다.
            }

            for(int l = 1; l <= n; l++){
                if (!visited[l]) { // 방문하지 않은 노드만 처리
                    color[l] = 0; // 초기 색상 설정
                    dfs(l);
                }
            }
            if (flag) {
                sb.append("possible\n");
            } else {
                sb.append("impossible\n");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {

        visited[start] = true;

        for(Integer a : arr.get(start)){
            if(!visited[a]){
                if(color[start] == 0){
                    color[a] = 1;
                }else{
                    color[a] = 0;
                }
                dfs(a);
            }else{
                if(color[a] == color[start]){
                    flag = false;
                    return;
                }
            }
            }

    }
}