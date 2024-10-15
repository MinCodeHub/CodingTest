import java.io.*;
import java.util.*;

public class Main {

    static int []dx = {-1,0,1,0};
    static int []dy = {0,-1,0,1};
    static char [][]graph;
    static boolean [][]visited;
    static int n;

    static int count;

    static int danji;
    static List<Integer> list = new ArrayList<>();
    //2667 - 단지번호 붙이기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        visited = new boolean[n][n];
        count = 1;
        danji = 0;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j<n;j++){
                graph[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(graph[i][j] == '1' && !visited[i][j]){
                    count = 1;
                    bfs(i,j);
                    danji++;
                }
            }
        }

        System.out.println(danji);

        Collections.sort(list); //오름차순
        for (int num : list) {
            bw.append(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            int nx = p.x;
            int ny = p.y;

            for(int k = 0; k < 4; k++){
                int nx1 = nx + dx[k];
                int ny2 = ny + dy[k];

                if(nx1 >= 0 && nx1<n && ny2>=0 && ny2<n){
                    if(graph[nx1][ny2] == '1'){
                        if(!visited[nx1][ny2]){
                            visited[nx1][ny2] = true;
                            queue.add(new Point(nx1,ny2));
                            count++;
                        }
                    }

                }
            }
        }
        list.add(count);
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}