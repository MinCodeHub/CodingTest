import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    //조합 + 백트래킹
    static int N,M;
    static int[] output;
    static int[] num;
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static boolean[] isVisited;
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        output = new int[M];
        isVisited = new boolean[N];

        for(int i=0; i<N;i++){
            num[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        comb(0,0);
        System.out.println(sb);

    }

    private static void comb(int start, int depth) {// 중복된 수 이거나 이미 방문한 수라면 통과함

        if(depth == M){
            for(int i = 0 ; i<M; i++){
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;

        for(int i = start; i < N; i++){
            int now = num[i];
            if(before == now || isVisited[i]){
                continue;
            }else{ // 아직 방문도 하지 않았고 중복된 수도 아니라면
                before = now;
                isVisited[i] = true;
                output[depth] = num[i];
                comb(i+1,depth+1);
                isVisited[i] = false;
            }

        }
    }
}