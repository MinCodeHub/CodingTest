import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면
    // 새로운 방을 생성하고 입장시킴.
    //이땐 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능
    //입장 가능한 방이 있다면 입장시킨 후 방의 전원이 모두 찰 때까지 대기
    //방 정ㅇ원이 모두 차면 게임 시작

    //p : 플레이어의 수
    //n : 플레이어의 닉네임
    // l: 플레이어의 레벨
    // m: 방 한개의 정원
    static  List<Room> rooms = new ArrayList<>();

    static int m;
    static int p;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Player newPlayer = new Player(level, nickname);

            boolean joined = false;
            for(Room room : rooms){
                if(room.canJoin(newPlayer)){
                    room.addPlayer(newPlayer);
                    joined = true;
                    break;
                }
            }
            if(!joined){
                Room newRoom = new Room(newPlayer);
                rooms.add(newRoom);
            }

        }
        // 출력
        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            room.sortPlayers();
            for (Player player : room.players) {
                sb.append(player.l).append(" ").append(player.n).append("\n");
            }
        }

        System.out.print(sb);
    }
}

class Player{
    int l=0; //레벨
    String n; //닉네임

    Player(int l, String n){
        this.l = l;
        this.n = n;
    }
}

class Room{
    int level;
    List<Player> players = new ArrayList<>();

    Room(Player p){
        this.level =p.l;
        players.add(p);
    }

    boolean canJoin(Player p){
        return (players.size() < Main.m) && Math.abs(p.l - level) <=10;
    }

    void addPlayer(Player p){
        players.add(p);
    }

    void sortPlayers(){
        players.sort(Comparator.comparing(player -> player.n));
    }
}

//이건 그냥 람다식 공부
/*
레벨이 같으면 닉네임으로 정렬 람다식
* players.sort(Comparator.comparing(player -> player.l)
                      .thenComparing(player -> player.n));

내림차순 정렬
players.sort(Comparator.comparing(player -> player.l).reversed());

* */