import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //프린터 큐
    static int t; //테스트 케이스

    static Queue<Integer>  q = new LinkedList<>(); //큐

    static int order = 0;

    static boolean no = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); //문서 개수
            int n = Integer.parseInt(st.nextToken()); //몇번째로 출력되는 지 알고 싶은 수의 큐 위치

            int wantlocation = n; //알고싶은 위치
            order = 0;
            q = new LinkedList<>(); //큐

            st = new StringTokenizer(br.readLine()); //중요도 입력 받음

            for(int j = 0 ; j < m; j++){
               int important = Integer.parseInt(st.nextToken());
                q.offer(important);
//                if(j == n){
//                    want = important; // 알고싶은 위치의 중요도를 저장함. 나중에 해당 중요도가 빠져나가면 그때의 순서 출력
//                }
            }

            while(!q.isEmpty()){

               int w = q.peek();  // 가장 앞에 있는 중요도
                no = true;

               for(int ww : q) {
                   if (w < ww) {  //위의 중요도보다 크면? 맨뒤로 보내야함
                       q.poll();
                       q.add(w);

                       if(wantlocation == 0){ //알고싶은 위치가 0이면 맨뒤의 위치로 바꾸고
                           wantlocation = q.size() - 1;
                       }else{
                           wantlocation= wantlocation-1; //0이 아니면 그냥 하나 빼줌.
                       }
                       no = false;
                       break;
                   }
               }

                   if(no){ //가장 앞에 있는게 우선순위가 높다면
                       int pollnum = q.poll();
                       order++;
//                       if(pollnum == want){
                       if(wantlocation == 0){
                           sb.append(order).append("\n");
                           break;
                       }
                       wantlocation= wantlocation-1;
                   }

           }
        }
        System.out.println(sb);

    }
}