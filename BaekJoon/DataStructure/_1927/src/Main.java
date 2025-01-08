import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    //최소 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int i =0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(minHeap.size()==0){
                    sb.append(0).append("\n");
                }else{
                    sb.append(minHeap.peek()).append("\n");
                    minHeap.remove();
                }
            }else{
                minHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}