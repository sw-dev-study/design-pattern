package hyundai.adapter;

import hyundai.AutoCar;
import hyundai.Gear;
import kia.KAutomaticCar;

public class KiaAdapter implements AutoCar {

    private KAutomaticCar kAutomaticCar;
    private static KiaAdapter kiaAdapter;

    private KiaAdapter(KAutomaticCar kAutomaticCar){
        this.kAutomaticCar = kAutomaticCar;
    }

    public static KiaAdapter getInstance(KAutomaticCar kAutomaticCar){
        if(kiaAdapter == null)
            kiaAdapter = new KiaAdapter(kAutomaticCar);
        else
            kiaAdapter.kAutomaticCar = kAutomaticCar;

        return kiaAdapter;
    }
    @Override
    public void accelerator() {
        kAutomaticCar.go();
    }

    @Override
    public void brake() {
        int i = 0;
        while(i++ < 3){
            kAutomaticCar.stop();
        }
    }

    @Override
    public void gearConversion(Gear gear) {
        kAutomaticCar.gearChange(gear);
    }

    @Override
    public void doorOpenClose() {
        throw new UnsupportedOperationException();
    }
}
