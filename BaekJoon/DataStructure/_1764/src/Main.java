import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //듣보잡 - 자료구조 공부
    //Hashset과 ArrayList 사용
    static int n,m;
    static int cnt;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i =0; i<n;i++){
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();

        for(int i =0; i<m; i++){
            String tmp = br.readLine();

            if(set.contains(tmp)){
                result.add(tmp);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }

    }
}