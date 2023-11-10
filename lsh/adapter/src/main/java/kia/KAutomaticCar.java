package kia;

import hyundai.Gear;

/**
 * 기아차에서 클라이언트에게 제공하는 인터페이스.
 */
public interface KAutomaticCar {

    //엑셀
    void go();

    //브레이크
    void stop();

    //기어 변환.
    void gearChange(Gear gear);

}