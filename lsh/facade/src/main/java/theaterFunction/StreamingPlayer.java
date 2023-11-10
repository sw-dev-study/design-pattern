package theaterFunction;

public class StreamingPlayer {

    //true - on, false - off
    private boolean status;
    private Amplifier amplifier;
    private Projector projector;
    private static StreamingPlayer player;

    private StreamingPlayer(){
        this.status = false;
    }

    public static StreamingPlayer getInstance(){
        if(player == null){
            player = new StreamingPlayer();
        }

        return player;
    }

    //스트리밍 플레이어 on
    public void on(){
        if(!status){
            this.status = true;
            System.out.println("플레이어를 켭니다.");
        }

    }
    //플레이어 재생
    public void startPlayer(String movieName){
        if(status){
            System.out.println(movieName + "를 재생합니다.");
        }
    }

    //off
    public void off(){
        if(status){
            this.status = false;
            System.out.println("플레이어를 끕니다...");
        }
    }

    //스트리밍 플레이어을 엠프에 연결

    public void connectAmplifier(Amplifier amplifier){
        this.amplifier = amplifier;
        System.out.println("플레이어와 엠프를 연결합니다.");
    }
    public void connectProjector(Projector projector){
        this.projector = projector;
        System.out.println("플레이어와 프로젝터를 연결합니다.");
    }


}
