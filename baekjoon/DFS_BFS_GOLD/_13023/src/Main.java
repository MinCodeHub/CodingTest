import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[]graph;
    static boolean []visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        //13023번 - ABCDE

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //초기화
        graph = new ArrayList[n];
        for(int i =0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n; i++){
            if(answer != 1)
                dfs(i,1);
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
    //문제의 조건에 맞는 A,B,C,D,E가 존재
        if(depth == 5){
            answer = 1;
            return;
        }
        visited[start]= true;

        for(int to : graph[start]){
            if(!visited[to]){
                dfs(to,depth+1);
            }
        }
        visited[start] = false;
    }

}