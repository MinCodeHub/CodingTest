//24.09.23

//봄버맨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r,c,n;
    static int []dh = {-1,0,1,0};
    static int []dw = {0,1,0,-1};
    static char [][]graph;
    static Queue<Point> q;

    static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        q = new LinkedList<>();

        //그래프 만들기
        for(int i = 0; i < r; i++){
            char []temp = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                graph[i][j] = temp[j];
            }
        }

        solve();

        for(int i =0;i<r; i++){
            for(int j = 0; j<c; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void solve() {
        int time = 1;
        while(time < n){

            //현재 폭탄 위치 큐에 넣기
            for(int i =0; i < r; i++){
                for(int j = 0; j<c; j++){
                    if (graph[i][j] == 'O') {
                        q.add(new Point(i,j));
                    }
                }
            }

            //빈 곳에 폭탄 채워 넣기 -> 큐에는 넣지 않음
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c;j++){
                    if(graph[i][j]== '.'){
                        graph[i][j] = 'O';
                    }
                }
            }
            time++; //시간 증가

            if(time == n) return;

            bomb(); //폭탄 터트리기
            time++;
        }
    }

    private static void bomb() {
        List<Point> bombList = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size --> 0){
                Point now = q.poll();
                bombList.add(new Point(now.x, now.y));

                for(int d=0; d<4; d++){
                    int ny = now.y + dh[d];
                    int nx = now.x + dw[d];

                    if(ny >= c || ny < 0 || nx >= r || nx < 0){
                        continue;
                    }
                    if(graph[nx][ny] == 'O'){
                        graph[nx][ny] = '.';
                    }
                }

            }
        }

        for(Point point: bombList){
            graph[point.x][point.y] = '.';
        }
    }


}