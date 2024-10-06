import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static Queue<Point> q;
    static boolean[]  visited;
    public static int max = 100000;
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        //13549번 - 숨박꼭질
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[100001];

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        bfs();
        System.out.println(count);
    }

    private static void bfs() {
        q.offer(new Point(n,0));

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int cnt = p.cnt;
            visited[x] = true;

            if(x == k)
                count = Math.min(count, cnt);
            if( x *2 <= max && !visited[x*2])
                q.offer(new Point(x*2, cnt));
            if( x + 1 <= max && !visited[x + 1])
                q.offer(new Point(x + 1 , cnt+1));
            if( x - 1 >= 0 && !visited[x - 1])
                q.offer(new Point(x - 1, cnt+1));
        }
    }

    static class Point{
        int x;
        int cnt;
        Point(int x, int cnt){

            this.x = x;
            this.cnt = cnt;
        }
    }
}
