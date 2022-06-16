package vitals;

public class ChargeRateValidator implements BatteryStatusValidator {

    @Override
    public boolean batteryIsOk(float validationValue) {
        if (validationValue > 0.8) {
            System.out.println("Charge Rate is out of range!");
            return false;
        }
        return true;
    }

}
