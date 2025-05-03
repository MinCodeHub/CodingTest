import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //달팽이
    public static void main(String[] args) throws IOException {
        int n;
        int[][] map;
        int target =0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //5
        target = Integer.parseInt(br.readLine()); //5

        map = new int[n][n];
        int num = 1;
        //시작위치: 배열의 정중앙
        int x = n/2;
        int y = n/2;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int len = 1; //이동거리
        int dir = 0; //방향
        int resultX = x;
        int resultY = y;

        map[x][y] = num; // 1을 먼저 넣음
        if (target == 1) {
            resultX = x;
            resultY = y;
        }

        num = 2;

        while(num <= n*n){
            for(int i = 0 ; i < 2; i++){  //두번 반복
                for(int j =0; j < len; j++){
                    x = x + dx[dir];
                    y = y + dy[dir];

                    if(x<n && y<n && x>=0 && y>=0){
                        map[x][y] = num;
                        if(target ==  num){
                            resultX = x;
                            resultY = y;
                        }
                        num++;
                    }
                }
                dir = (dir+1) % 4;
            }
            len++;
        }

        for(int i =0; i<n; i++){
            for(int j = 0; j<n;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println((resultX+1) +" "+(resultY+1));



    }
}