import javax.xml.stream.events.StartDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //NBA 농구
    //NBA 48분동안 진행됨.
    //각 팀이 몇분동안 이기고 있었는지 출력
    static int n;
    static final int END_TIME = 48 * 60;
    static LinkedList<Team> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String time;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            time = st.nextToken();
            list.add(new Team(team, time));
        }

       int score1 = 0;
        int score2 = 0;
        int lead1 = 0;
        int lead2 =0;

        int prevTime = 0;

        for(Team t : list){
            int curTime = timeToSeconds(t.time);

            //리드 팀 시간 누적
            if(score1 > score2){
                lead1 += (curTime - prevTime);
            }else if(score2 > score1){
                lead2 += (curTime - prevTime);
            }

            if(t.teamNum == 1){
                score1++;
            }else{
                score2++;
            }

            prevTime = curTime;
        }

        if(score1 > score2){
            lead1 += (END_TIME -prevTime);

        }else if(score2 > score1){
            lead2 += (END_TIME - prevTime);
        }
        // 결과 출력
        System.out.println(secondsToTime(lead1));
        System.out.println(secondsToTime(lead2));
    }

    private static int timeToSeconds(String time){
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 +seconds;
    }

    private static String secondsToTime(int totalSeconds){
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes,seconds);
    }
}

class Team{
    int teamNum=0;
    String time;

    Team(int teamNum, String time){
        this.teamNum = teamNum;
        this.time = time;
    }
}