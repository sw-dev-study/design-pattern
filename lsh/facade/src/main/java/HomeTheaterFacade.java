import theaterFunction.*;

public class HomeTheaterFacade {

    private Amplifier amplifier;
    private PopcornPopper popcornPopper;
    private Projector projector;
    private Screen screen;
    private StreamingPlayer streamingPlayer;
    private TheaterLights theaterLights;

    private static HomeTheaterFacade homeTheaterFacade;

    private HomeTheaterFacade(){
        this.amplifier = Amplifier.getInstance();
        this.popcornPopper = PopcornPopper.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.streamingPlayer = StreamingPlayer.getInstance();
        this.theaterLights = TheaterLights.getInstance();
    }

    public static HomeTheaterFacade getInstance(){
        if(homeTheaterFacade == null){
            homeTheaterFacade = new HomeTheaterFacade();
        }
        return homeTheaterFacade;

    }


    public void startMovie(String movieName){
//        1. 팝콘기계를 켠다.
        popcornPopper.on();
//        2. 팝콘을 튀긴다.
        popcornPopper.popcornStart();
//        3. 조명을 끈다.
        theaterLights.off();
//        4. 스크린을 내린다.
        screen.down();
//        5. 프로젝터를 킨다.
        projector.on();
//        6. 프로젝터를 스트리밍 플레이어로 설정한다.
        projector.setPlayer(streamingPlayer);
//        7. 앰프를 켠다.
        amplifier.on();
//        8. 앰프 입력을 스트리밍 플레이어로 설정한다,.
        amplifier.setStreamingPlayer(streamingPlayer);
//        9. 스트리밍 플레이어를 켠다.
        streamingPlayer.on();
//        10. 영화를 재생한다.
        streamingPlayer.startPlayer(movieName);
    }

    public void endMovie(){
//        1. 스트리밍 플레이어를 종료한다.
        streamingPlayer.off();
//        2. 앰프를 끈다.
        amplifier.off();
//        3. 프로젝터를 끈다.
        projector.off();
//        4. 스크린을 올린다.
        screen.up();
//        5. 조명을 끈다.
        theaterLights.off();
//        6. 팝콘기계를 끈다.
        popcornPopper.off();

    }

}
