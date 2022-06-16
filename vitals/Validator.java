package vitals;

public class Validator {
    private BatteryStatusValidator batteryStatusValidator;

    public Validator(BatteryStatusValidator batteryStatusValidator) {
        this.batteryStatusValidator = batteryStatusValidator;
    }

    public boolean executeValidator(float validateValue) {
        return batteryStatusValidator.batteryIsOk(validateValue);
    }
}
