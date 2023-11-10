package hyundai;

public class Genesis implements AutoCar{

    private int speed;
    private Gear gear;
    private Door door;

    public Genesis(){
        this.speed = 0;
        this.gear = Gear.N;
        this.door = Door.CLOSE;
    }
    @Override
    public void accelerator() {
        System.out.println("부우우웅 가속합니다.");
        this.speed += 10;
    }

    @Override
    public void brake() {
        System.out.println("스르륵 차가 멈춥니다.");
        this.speed = 0;
    }

    @Override
    public void gearConversion(Gear gear) {

        System.out.println("딸깍, 기어를 " + "[" + gear + "]" + " 로 변환합니다.");
        this.gear = gear;
    }

    @Override
    public void doorOpenClose() {

       if(Door.OPEN == this.door){
           System.out.println("문이 스르륵 닫힙니다.");
           this.door = Door.CLOSE;
       }
       else{
           System.out.println("문이 스르륵 열립니다.");
           this.door = Door.OPEN;
       }
    }
}
