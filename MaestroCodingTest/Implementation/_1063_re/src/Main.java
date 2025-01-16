import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //킹
    static char [] king;
    static char [] stone;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();

        //king[0] = A  king[1] = 1
        //stone[0] = A stone[1] = 2

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
           char[] newking =  move(king, command); //킹을 먼저 움직이게 함.
            if(isInRange(newking)){  // 범위 내에 있을 때
                if(newking[0] == stone[0] && newking[1] == stone[1]){ //돌의 위치랑 같으면
                    char[] nextStone = move(stone,command); // 돌도 같은 방향으로 이동
                    if(isInRange(nextStone)) { //돌도 범위 내에 있으면
                        king = newking; //자리 고정
                        stone = nextStone; //자리 고정
                        } // 범위 내에 없으면 킹,돌 모두 이동 안함.
                    }
                else{ //돌이랑 위치가 같지 않으면 돌은 이동 안하고 킹만 이동하고 위치 고정.
                    king = newking;
                }
                }
            }
        System.out.println(king[0] + "" + king[1]);
        System.out.println(stone[0] + "" + stone[1]);
        }
    private static boolean isInRange(char[] a) {
        if(a[0] < 'A' || a[0] > 'H' || a[1]<'1' ||a[1] >'8') {
            return false;
        }else{
            return true;
        }
    }
    private static char[] move(char[] ks, String command) {

        char[] newking = ks.clone();

        if(command.equals("B")){
            newking[1]--;
        }else if(command.equals("L")){
            newking[0]--;
        }else if(command.equals("R")){
            newking[0]++;
        }else if(command.equals("T")){
            newking[1]++;
        }else if(command.equals("RT")){
            newking[0]++;
            newking[1]++;
        }else if(command.equals("LT")){
            newking[0]--;
            newking[1]++;
        }else if(command.equals("RB")){
            newking[0]++;
            newking[1]--;
        }else if(command.equals("LB")){
            newking[0]--;
            newking[1]--;
        }

        return newking;
    }
}