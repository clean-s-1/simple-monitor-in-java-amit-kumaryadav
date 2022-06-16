package vitals;

public class SocValidator implements BatteryStatusValidator {

    @Override
    public boolean batteryIsOk(float validationValue) {
        if (validationValue < 20 || validationValue > 80) {
            System.out.println("State of Charge is out of range!");
            return false;
        }
        return true;
    }

}
