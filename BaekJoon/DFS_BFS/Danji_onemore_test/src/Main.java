import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    //2667번 단지 번호 붙이기 복습
    //일단 그래프 먼저 생성하기
    static int arr[][];
    static boolean visit[][];

    static int N;
    static int count = 0;
    static int number = 0;

    static int dicX[]={0,0,-1,1};
    static int dicY[]={-1,1,0,0};
    static int nowX, nowY;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        //그래프 생성
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
            arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                if(visit[i][j] == false && arr[i][j] == 1){
                    count = 0;
                    number++;
                    //dfs호출
                    DFS(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        bw.append(number+"\n");

        for(int num: list){
            bw.append(num+ "\n");
        }

        bw.flush();
        bw.close();

    }

    static void DFS(int X, int Y){
        visit[X][Y] = true;
        arr[X][Y] = number;
        count++;
        for(int i = 0; i< 4; i++){
            nowX = dicX[i]+X;
            nowY = dicY[i]+Y;

            if(Range_check() && arr[nowX][nowY] == 1 && visit[nowX][nowY] == false ){
                visit[nowX][nowY] = true;
                arr[nowX][nowY] = number;
                DFS(nowX, nowY);
            }
        }
    }

    static boolean Range_check(){
        return(nowX >= 0&& nowX < N && nowY >=0 && nowY < N);

    }
}