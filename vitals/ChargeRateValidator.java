package vitals;

import java.util.ArrayList;

public class ChargeRateValidator implements Validator {

    float validationValue;
    String unitType;
    boolean isMessageEnabled;

    public ChargeRateValidator(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }

    @Override
    public float translateToCommonUnits() {
        return this.validationValue;
    }

    @Override
    public ArrayList<String> getWarningList(float validationValue) {
        if(this.isMessageEnabled) {
            BoundryConditions boundryConditions = new BoundryConditions();
            return boundryConditions.getMessagesBasedOnValue(validationValue, "chargeRate", "WARNING");
        }
        return new ArrayList<>();
        }

    @Override
    public ArrayList<String> getErrorList(float validationValue) {
        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "chargeRate", "BREACH");
    }

    @Override
    public boolean batteryIsOk() {
        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "chargeRate", "BREACH").isEmpty();
    }
}
