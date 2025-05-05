import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/* 문제
- 실버 3 문자열
- 확장자 별로 구분해서 개수 세기
- 사전순으로 정렬
* */

/*
소요시간
- 25분 48초

막힌 부분
- 20920 문제에서 Map-> List로 감싸서 정렬하는 문제와 비슷한 문제 다시 풀어봄
- .으로 문자열을 나눠야할 때 "\\."으로 해야 제대로 나누어짐
* */
public class Main {
    //파일 정리
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] extendstr= new String[2];
        for(int i =0; i<n; i++){

            String str = br.readLine();
            extendstr = str.split("\\.");
            String s = extendstr[1];
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                int v = map.get(s);
                map.replace(s,v+1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->{return a.getKey().compareTo(b.getKey());});

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,Integer> m : list){
            sb.append(m.getKey()).append(" ").append(m.getValue()).append("\n");
        }

        System.out.println(sb);



    }
}