import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //스위치 켜고 끄기
    static int n; //스위치 개수
    static int[] onoff; //스위치 상태

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        onoff = new int[n + 1];

        for (int i = 1; i <= n; i++) { //1부터 n까지
            onoff[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); //학생 수

        for (int j = 0; j < m; j++) { //학생 수만큼 돌리고
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int receiveNum = Integer.parseInt(st.nextToken());

            OnOffSwitch(gender, receiveNum);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(onoff[i] + " ");
            if ((i % 20) == 0) {
                System.out.println();
            }
        }

    }

    private static void OnOffSwitch(int gender, int receiveNum) {

        if (gender == 1) { //남자일 때
            for (int i = receiveNum; i <= n; i++) {
                if (i % receiveNum == 0) {
                    if (onoff[i] == 1) {
                        onoff[i] = 0;
                    } else {
                        onoff[i] = 1;
                    }
                }
            }
        } else if (gender == 2) { //여자일 때

            //자기 자신 바꾸고
            if (onoff[receiveNum] == 1) {
                onoff[receiveNum] = 0;
            } else {
                onoff[receiveNum] = 1;
            }
            int k = 1;
            while (receiveNum - k > 0 && receiveNum + k <= n) {
                if (onoff[receiveNum - k] == onoff[receiveNum + k]) {
                    if (onoff[receiveNum - k] == 1) {
                        onoff[receiveNum - k] = 0;
                        onoff[receiveNum + k] = 0;
                    } else {
                        onoff[receiveNum - k] = 1;
                        onoff[receiveNum + k] = 1;
                    }
                } else {
                    break;
                }
                k++;
            }
        }

    }
}