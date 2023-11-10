package theaterFunction;

public class PopcornPopper {


    private boolean onOffStatus;
    private static PopcornPopper popcornPopper;

    private PopcornPopper(){

        onOffStatus = false;
    }

    public static PopcornPopper getInstance(){
        if(popcornPopper == null){
            popcornPopper = new PopcornPopper();
        }

        return popcornPopper;
    }

    //기계 on
    public void on(){

        if(!onOffStatus){
            this.onOffStatus = true;
            System.out.println("팝콘 기계가 켜집니다....");
        }
    }

    //기계 off
    public void off(){

        if(onOffStatus){
            this.onOffStatus = false;
            System.out.println("팝콘 기계를 끕니다.");
        }
    }

    //팝콘 튀기기.
    public void popcornStart(){

        if(onOffStatus){
            System.out.println("팝콘을 튀깁니다.");
        }
    }
}
