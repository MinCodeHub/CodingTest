import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //크로스 컨트리
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashMap<Integer, List<Integer>> teamScores = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int t = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        int[] score; //등수에 따른 점수
        int[] team;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            score = new int[n];
            team = new int[n];
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                team[j] = tmp;

                if (!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                } else {
                    int v = map.get(tmp);
                    map.replace(tmp, v + 1);
                }
            }
            for(int k = 0; k < n; k++){
                if(checkingTeamSixMember(team[k])){ //6명이라면
                    score[k] = cnt + 1;
                    cnt++;
                }else{ //6명이 아니라면 0을 넣어라. 점수 체크 안함.
                    score[k] = 0;
                }
            }


            //팀원이 6명인 팀만 점수 넣기
            for(int l =0; l<n;l++){
                if(score[l] != 0){
                    if(!teamScores.containsKey(team[l])){
                        teamScores.put(team[l], new ArrayList<>());
                    }
                    teamScores.get(team[l]).add(score[l]);
                }
            }

            int winner = -1;
            int minScore = Integer.MAX_VALUE;

            for(int teamNum: teamScores.keySet()){
                List<Integer> scores= teamScores.get(teamNum);
                if(scores.size()<5)
                    continue;

                int sum = 0;

                for(int s = 0; s<4; s++){
                    sum +=scores.get(s);
                }

                if(sum < minScore){
                    minScore = sum;
                    winner = teamNum;
                }else if(sum == minScore){
                    int fifthA = teamScores.get(winner).get(4);
                    int fifthB = scores.get(4);

                    if(fifthB < fifthA){
                        winner = teamNum;
                    }
                }
            }
            System.out.println(winner);
            map.clear();
            teamScores.clear();

        }


    }
    public static boolean checkingTeamSixMember(int teamNum) {

        if(map.containsKey(teamNum)){
            if(map.get(teamNum)==6){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

}