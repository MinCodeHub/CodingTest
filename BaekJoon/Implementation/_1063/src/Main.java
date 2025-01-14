import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //빡구현 - 킹 1063번
    //입력: 킹 위치 돌 위치 이동횟수
    /*
    R : 한 칸 오른쪽으로
    L : 한 칸 왼쪽으로
    B : 한 칸 아래로
    T : 한 칸 위로
    RT : 오른쪽 위 대각선으로
    LT : 왼쪽 위 대각선으로
    RB : 오른쪽 아래 대각선으로
    LB : 왼쪽 아래 대각선으로
    * */
    static char[] king, stone;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char[] nextKing = move(command, king);

            if(isInRange(nextKing)){
                if (nextKing[0] == stone[0] && nextKing[1] == stone[1]) { // 킹이 돌과 겹치면
                    char[] nextStone = move(command, stone);

                    if (isInRange(nextStone)) { // 돌이 체스판 안에 있으면
                        king = nextKing;
                        stone = nextStone;
                    }
                } else {
                    king = nextKing;
                }
            }
        }

        System.out.println(king[0] + "" + king[1]);
        System.out.println(stone[0] + "" + stone[1]);
    }

    //범위 안에 있는지?
    private static boolean isInRange(char[] a) {
        if(a[0] < 'A' || a[0] > 'H' || a[1]<'1' ||a[1] >'8') {
            return false;
        }else{
            return true;
        }
    }

    private static char[] move(String command, char[] target) {
        char[] result = target.clone();

        if (command.equals("R")) {
            result[0]++;
        } else if (command.equals("L")) {
            result[0]--;
        } else if (command.equals("B")) {
            result[1]--;
        } else if (command.equals("T")) {
            result[1]++;
        } else if (command.equals("RT")) {
            result[0]++;
            result[1]--;
        } else if (command.equals("LT")) {
            result[0]--;
            result[1]++;
        } else if (command.equals("RB")) {
            result[0]++;
            result[1]--;
        } else if (command.equals("LB")) {
            result[0]--;
            result[1]--;
        }
        return result;
    }
}