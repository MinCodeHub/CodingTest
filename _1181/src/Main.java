import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int n;
    static String[] arr;

    public static void main(String[] args) throws IOException {
       //단어 정렬

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new String[n];

        for(int i=0; i<n;i++){
            String str = br.readLine();
            arr[i] = str;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //단어의 길이가 같을 경우
                 if(s1.length() == s2.length()){
                     return s1.compareTo(s2);
                 }
                 //그외의 경우
                 else{
                     return s1.length() - s2.length();
                 }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append('\n');


        for(int i =1; i<n; i++){
            //중복되지 않는 단어만 출력

            if(!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}