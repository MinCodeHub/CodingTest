import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //영단어 암기는 괴로워
    public static void main(String[] args) throws IOException {
        int n = 0;
        int m = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i =0 ; i<n; i++){
            String  line = br.readLine();

            if(line.length() < m){
                //그냥 읽기만해도 외워지는 것
                continue;
            }else if(!map.containsKey(line)){
                //line을 이미 가지고 있으면
                map.put(line,1);
            }else if(map.containsKey(line)){
                int v = map.get(line);
                map.replace(line,v+1);
            }
        }

        int max = 0;

        //최댓값 찾기
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->{
            if(!a.getValue().equals(b.getValue())){
                return b.getValue() - a.getValue();
            }else if(a.getKey().length() != b.getKey().length()){
                return b.getKey().length() - a.getKey().length();
            }else{
                return a.getKey().compareTo(b.getKey());
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry:list){
            sb.append(entry.getKey()).append("\n");
        }

        System.out.print(sb.toString());
    }
}