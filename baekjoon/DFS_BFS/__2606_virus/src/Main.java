
import java.io.*;
import java.util.*;

public class Main {
    static  int num,connections;
    static int [][]arr; //배열
    static boolean []visited;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        //바이러스 - BFS

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine()); //컴퓨터의 개수
        connections = Integer.parseInt(br.readLine()); //연결 수

        visited = new boolean[num+1];

        arr = new int[num+1][num+1];

        for(int j = 0 ; j < connections; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        bfs(1);
        System.out.println(result);
    }

    //bfs그래프 - 큐, 링크드리스트 사용, 선입선출
    public static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 1; i<= num; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    result++;
                }
            }
        }

    }
}