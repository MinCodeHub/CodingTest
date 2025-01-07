import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    //세 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>(3);

        st = new StringTokenizer(br.readLine());

        arr.add(Integer.parseInt(st.nextToken()));
        arr.add(Integer.parseInt(st.nextToken()));
        arr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arr);

        System.out.println(arr.get(1));



    }
}