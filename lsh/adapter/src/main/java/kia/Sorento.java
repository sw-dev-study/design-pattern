package kia;

import hyundai.Door;
import hyundai.Gear;

public class Sorento implements KAutomaticCar{
    private int speed;
    private Gear gear;
    private Door door;
    @Override
    public void go() {
        System.out.println("위이이이~~~~~~~잉 전진합니다.");
        this.speed += 5;
    }

    @Override
    public void stop() {
        System.out.println("끼이익 차가 멈춥니다.");
        this.speed = 0;
    }

    @Override
    public void gearChange(Gear gear) {
        System.out.println("까가가각, 기어를 " + "[" + gear + "]" + " 로 변환합니다.");
        this.gear = gear;
    }
}
