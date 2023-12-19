package theaterFunction;

public class TheaterLights {

    //true - 불이 켜져있음, false, 불이 꺼져있음.
    private boolean status;
    private static TheaterLights theaterLights;

    private TheaterLights(){
        this.status = false;
    }

    public static TheaterLights getInstance(){
        if(theaterLights == null){
            theaterLights = new TheaterLights();
        }

        return theaterLights;
    }

    //불을 켠다
    public void on(){
        if(!status){
            this.status = true;
            System.out.println("조명을 켭니다....");
        }
    }

    //끈다.
    public void off(){

        if(status){
            this.status = false;
            System.out.println("조명을 끕니다.....");
        }

    }
    //조명을 부순다
    protected void breakLight(){

        this.status = false;
        System.out.println("조명을 부순다.....");
    }
}
