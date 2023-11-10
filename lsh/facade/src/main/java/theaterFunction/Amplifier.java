package theaterFunction;

public class Amplifier {

    private StreamingPlayer player;
    private static Amplifier amplifier;

    private Amplifier(){

    }

    public static Amplifier getInstance(){

        if(amplifier == null){
            amplifier = new Amplifier();
        }

        return amplifier;
    }

    public void on(){

        System.out.println("앰프가 켜집니다....");

    }
    public void off(){
        System.out.println("앰프가 꺼집니다....");
    }
    public void setStreamingPlayer(StreamingPlayer player){

        this.player = player;
        System.out.println("앰프의 입력을 스트리밍플레이어로 변경합니다.....");
        player.connectAmplifier(this);
    }


}
