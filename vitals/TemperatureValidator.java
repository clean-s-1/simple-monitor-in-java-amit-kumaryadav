package vitals;

public class TemperatureValidator implements BatteryStatusValidator {

    @Override
    public boolean batteryIsOk(float validationValue) {
        if (validationValue < 0 || validationValue > 45) {
            System.out.println("Temperature is out of range!");
            return false;
        }
        return true;
    }

}
