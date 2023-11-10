package theaterFunction;

public class Screen {

    //true - 완전히 내려감, false 올라감.
    private boolean status;
    private static Screen screen;

    private Screen(){
        this.status = false;
    }

    public static Screen getInstance(){
        if(screen == null){
            screen = new Screen();
        }

        return screen;
    }

    //스크린 올리기
    public void up(){
        if(status){
            this.status = false;
            System.out.println("스크린이 올라갑니다....");
        }
    }

    //스크린 내리기
    public void down(){
        if(!status){
            this.status = true;
            System.out.println("스크린이 내려갑니다.....");
        }
    }

}
