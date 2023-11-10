package hkcar;

import hyundai.AutoCar;
import hyundai.Gear;
import hyundai.adapter.KiaAdapter;
import kia.Sorento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HyundaiKiaCarTest {


    @Test
    @DisplayName("현기차 - 어댑터를 이용하지 않고 기아차 기능 호출")
    void notAdapterTest(){

        Sorento sorento = new Sorento();

        sorento.go();

        sorento.stop();

        sorento.gearChange(Gear.D);

    }

    @Test
    @DisplayName("현기차 - 어댑터를 이용하여 현기차 기능 호출")
    void adapterTest(){

        AutoCar autoCar = KiaAdapter.getInstance(new Sorento());

        //전진
        autoCar.accelerator();

        //브레이크
        autoCar.brake();

        //기어변경
        autoCar.gearConversion(Gear.D);

        //문 작동
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            autoCar.doorOpenClose();
        });
    }
}
