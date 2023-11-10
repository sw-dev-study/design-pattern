package theaterFunction;


public class Projector {

    private boolean onOffStatus;
    private StreamingPlayer player;
    private static Projector projector;

    private Projector(){
    }

    public static Projector getInstance(){
        if(projector == null){
            projector = new Projector();
        }

        return projector;
    }

    //프로젝터를 켬
    public void on(){

        if(!onOffStatus){
            onOffStatus = true;
            System.out.println("프로젝터가 켜집니다....");
        }
    }

    //프로젝터를 끔
    public void off(){

        if(onOffStatus){
            onOffStatus = false;
            System.out.println("프로젝트를 끕니다...");
        }

    }

    //프로젝터 입력을 스프리밍 플레이어로 변경.
    public void setPlayer(StreamingPlayer player){
        this.player = player;
        System.out.println("프로젝터 입력을 스트리밍 플레이어로 변경합니다.");
        player.connectProjector(this);
    }

}
