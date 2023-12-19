import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import theaterFunction.*;

public class HomeTheaterTest {


    @Test
    @DisplayName("홈시어터 테스트 - 파사드 없이 직접 홈시어터 on테스트")
    void notFacadeOnTest(){
        Amplifier amplifier = Amplifier.getInstance();
        PopcornPopper popcornPopper = PopcornPopper.getInstance();
        Projector projector = Projector.getInstance();
        Screen screen = Screen.getInstance();
        StreamingPlayer streamingPlayer = StreamingPlayer.getInstance();
        TheaterLights theaterLights = TheaterLights.getInstance();


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
        streamingPlayer.startPlayer("존윅4");


    }
    @Test
    @DisplayName("홈시어터 테스트 - 파사드 없이 직접 홈시어터 off테스트")
    void notFacadeOffTest(){
        Amplifier amplifier = Amplifier.getInstance();
        PopcornPopper popcornPopper = PopcornPopper.getInstance();
        Projector projector = Projector.getInstance();
        Screen screen = Screen.getInstance();
        StreamingPlayer streamingPlayer = StreamingPlayer.getInstance();
        TheaterLights theaterLights = TheaterLights.getInstance();

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
    @Test
    @DisplayName("홈시어터 테스트 - 파사드를 통한 홈시어터 on테스트")
    void facadeOnTest(){
        HomeTheaterFacade homeTheaterFacade = HomeTheaterFacade.getInstance();

        homeTheaterFacade.startMovie("존윅4");
    }
    @Test
    @DisplayName("홈시어터 테스트 - 파사드를 통한 홈시어터 off테스트")
    void facadeOffTest(){
        HomeTheaterFacade homeTheaterFacade = HomeTheaterFacade.getInstance();

        homeTheaterFacade.endMovie();
    }
}
