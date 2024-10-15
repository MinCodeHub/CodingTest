import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
     1325 효율적인 해킹
     N개의 컴퓨터
     M개의 신뢰 관계
     신뢰하는 관계, 신뢰하지 않는 관계
     N <= 10000
     M <=1 00000
     둘째 줄
       5
       |
     1-3-2    3이 1을 신뢰 : 1을 해킹하면, 3을 해킹할 수 있음
       |      3이 2를 신뢰:  2를 해킹하면 3를 해킹할 수 있음
       4      4가 3을 신뢰 : 3을 해킹하면 4를 해킹할 수 있음
              5가 3을 신뢰 : 3을 해킹하면 5를 해킹할 수 있음


     1을 해킹 -> 3해킹 -> 4,5해킹 (4개 해킹 가능)
     2를 해킹 -> 3을 해킹 ->4,5,해킹(4개 해킹 가능)
     3을 해킹 -> 4,5 해킹(3개 해킹 가능)
     4를 해킹 -> 아무도 못함(1개 해킹 가능)
     5를 해킹 -> 아무도 못함(1개 해킹 가능)

     n개의 해킹 배열 생성
     방향이 있는그래프같은디ㅣ...
     dfs 로 풀기
     */
public class Main {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean []visited;
    static int count;
    static int []check;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n + 1];
        check = new int[n+1];
        max = 0;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int j = 0; j < m; j++) {
             st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n2].add(n1);
        }

        for(int i = 1;i <= n; i++){
            visited = new boolean[n + 1];
            count = 1;
            dfs(i);
            check[i] = count;
            if(max <= check[i]){
                max = check[i];
            }
        }

        for(int i = 1;i <= n; i++){
            if(check[i] == max){
                System.out.print(i+" ");
            }
        }


    }

    private static void dfs(int start) {
       visited[start] = true;
       for(int node : graph[start]){
           if(!visited[node]){
               count++;
               dfs(node);
           }
       }

    }
}