package hyundai;

public class Avante implements AutoCar{
    private int speed;
    private Gear gear;
    private Door door;

    public Avante(){
        this.speed = 0;
        this.gear = Gear.N;
        this.door = Door.CLOSE;
    }
    @Override
    public void accelerator() {
        System.out.println("위이이이잉 가속합니다.");
        this.speed += 5;
    }

    @Override
    public void brake() {
        System.out.println("끼익! 차가 멈춥니다.");
        this.speed = 0;
    }

    @Override
    public void gearConversion(Gear gear) {

        System.out.println("끼기기긱, 기어를 " + "[" + gear + "]" + " 로 변환합니다.");
        this.gear = gear;
    }

    @Override
    public void doorOpenClose() {

        if(Door.OPEN == this.door){
            System.out.println("문이 쾅 닫힙니다.");
            this.door = Door.CLOSE;
        }
        else{
            System.out.println("문이 덜컥 열립니다.");
            this.door = Door.OPEN;
        }

    }
}
