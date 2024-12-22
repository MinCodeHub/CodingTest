import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int f1,f2;
    static List<Integer>[] relation;
    static boolean[] visited;
    static int result = -1;


    public static void main(String[] args) throws IOException {
        //촌수 계산

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //사람 수

        relation = new ArrayList[n+1];
        visited = new boolean[n+1];

        //배열 초기화
        for(int i = 1; i<n+1; i++){
            relation[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        f1 = Integer.parseInt(st.nextToken());
        f2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i =0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            relation[p].add(c);
            relation[c].add(p);
        }

        dfs(f1,f2,0);
        System.out.println(result);

    }

    private static void dfs(int start, int end, int cnt) {

        if(start == end){
            result = cnt;
            return;
        }
        visited[start] = true;

        for(int i =0; i < relation[start].size(); i++){
            int s = relation[start].get(i);

            if(!visited[s]){
                dfs(s, end, cnt+1);
            }
        }
    }
}