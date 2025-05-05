import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 문제
- 실버 3 문자열
- 자주 나오는 단어일 수록 앞에 배치
- 해당 단어의 길이가 길수록 앞에 배치
- 알파벳 사전 순으로 앞에 있는 단어일수 록 앞에 배치
- M보다 짧은 길이는 패스
* */
/*

소요시간
- 28분 3초

막힌 부분
- 또 Map을 List화해서 정렬하는 부분에서 막혔음.

시간초과
- StringBuilder를 사용해서 시간 초과 해결
* */
public class Main {

//한번 더 풀기

    public static void main(String[] args) throws IOException {

        int n;
        int m;
        Map<String,Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        for(int i =0; i<n; i++){
           String str = br.readLine();
           if(str.length() < m){
               continue; //m보다 길이가 작으면.. pass
           }
           if(!map.containsKey(str)){
               map.put(str, 1);
           }else{
               int v = map.get(str);
               map.replace(str, v+1);
           }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->{
            if(a.getValue() != b.getValue()){
                return b.getValue() - a.getValue();
            }else if(a.getKey().length() != b.getKey().length()){
                return b.getKey().length() - a.getKey().length();
            }else{
                return a.getKey().compareTo(b.getKey());
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> l : list){
            sb.append(l.getKey()).append("\n");
        }

        System.out.println(sb);

    }
}


