import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //20546 - 기적의 매매법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int []arr = new int[14];

        int zun=0;
        int sung=0;
        int zn = n;
        int sn = n;

        int resultz = 0;
        int results = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<14; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //준혁
        for(int i=0; i < 14; i++){
            if(zn > 0 && zn >= arr[i]){
                zun += zn / arr[i];
                zn -= zun * arr[i];//잔돈 체크
                //System.out.println("산 날짜:" + i+"주식 수 "+zun +"남은 돈" +zn);
            }
        }
        resultz = zn + zun*arr[13];
        //System.out.println("resultz: "+resultz);

        //성민
        for(int i = 3; i < 14; i++){
                    if((arr[i-3] < arr[i-2] )&&(arr[i-2] < arr[i-1])){
                        //연속 3일 상승한 상황 -> 떨어질 것 예상 -> 다 팔아버림
                        sn += sung * arr[i];
                        sung = 0;
                       // System.out.println("팡아버린 날짜:" + i+"주식 수 "+sung +"남은 돈" +sn);
                    }
                    if((arr[i-3] > arr[i-2] )&&(arr[i-2] > arr[i-1]) && sn >= arr[i]){
                        //연속 3일 하락한 상황 -> 상승할 것 예상 -> 사버림
                        sung += sn/arr[i];
                        sn -= (sn/arr[i]) * arr[i]; //잔돈
                       // System.out.println("산 날짜:" + i+"주식 수 "+sung +"남은 돈" +sn);
                    }
            }

        results = sn + sung*arr[13];
        //System.out.println("results :"+results);
        if(resultz > results){

            System.out.println("BNP");
        } else if (resultz < results) {
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }

    }
}