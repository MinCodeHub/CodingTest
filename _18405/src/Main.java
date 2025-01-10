package _18405.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //경쟁적 전염
    static int n,k;
    static boolean[] visited;

    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,-1,0,1};

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[x][y] = b;
        }

        st = new StringTokenizer(br.readLine());
        int xx = Integer.parseInt(st.nextToken());
        int yy = Integer.parseInt(st.nextToken());
        int bb = Integer.parseInt(st.nextToken());

    }
}