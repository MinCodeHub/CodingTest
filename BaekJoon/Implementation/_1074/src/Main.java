import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        //Z 분할정복 , 재귀
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        //결과값을 저장할 변수
        int result = 0;

        //재귀
        System.out.println(z(n,x,y,result));
    }

    private static int z(int n, int x, int y, int result) {

        //n이
        if(n == 0){
            return result;
        }
        //해당 (x,y)좌표의 사분면을 구하고 좌표 수정하기
        int half = (int) Math.pow(2,n-1);
        int quadrant;

        if(x >= half && y >= half){
            quadrant = 3;
            x-=half;
            y-=half;
        }else if(x<half && y>=half){
            quadrant = 2;
            y-=half;
        }else if(x>=half && y < half){
            quadrant = 1;
            x-=half;
        }else{
            quadrant = 0;
        }

        int initNum = (int) Math.pow(4, n-1);
        result += (initNum * quadrant);

        return z(--n, x, y, result);
    }
}