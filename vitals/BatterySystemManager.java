package vitals;

public class BatterySystemManager {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean temperatureValidationResult = new Validator(new TemperatureValidator()).executeValidator(temperature);
        boolean socValidationResult = new Validator(new SocValidator()).executeValidator(soc);
        boolean chargeValidationRateResult = new Validator(new ChargeRateValidator()).executeValidator(chargeRate);
        return (temperatureValidationResult && socValidationResult && chargeValidationRateResult);
    }

    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f) == true);
        assert (batteryIsOk(50, 85, 0.0f) == false);

        assert (batteryIsOk(50, 81, 0.0f) == false);
        assert (batteryIsOk(50, 10, 0.81f) == false);
        assert (batteryIsOk(50, 85, 1) == false);
        assert(batteryIsOk(12, 40, 0.6f) == true);
        assert(batteryIsOk(20, 50, 0.6f) == true);
        assert(batteryIsOk(45, 20, 0.8f) == true);
        assert(batteryIsOk(0, 80, 0.8f) == true);
    }
}
