import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Sol1{

    class Solution {
        public int solution(String[][] clothes) {

            HashMap<String, Integer> map = new HashMap<>();
            int answer = 1;

            //1. 옷을 종류별로 그룹화
            for(String[] cloth : clothes){
                String type = cloth[1]; //의상의 종류
                map.put(type, map.getOrDefault(type,0)+1);
            }

            //2. 조합 계산
            for(int count : map.values()){
                answer *= (count+1); //각 종류에서 의상 선택, 혹은 선택하지 않는 경우
            }

            //옷을 안입는 경우 제외
            answer -=1;

            return answer;
        }
    }
}