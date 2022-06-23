package vitals;

public class SystemInput {
    float validationValue;
    String unitType;
    boolean isMessageEnabled;
    public SystemInput(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }
}
