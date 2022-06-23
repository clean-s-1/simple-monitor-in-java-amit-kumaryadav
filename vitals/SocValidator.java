package vitals;

import java.util.ArrayList;

public class SocValidator implements Validator {

    float validationValue;
    String unitType;
    boolean isMessageEnabled;

    public SocValidator(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }

    @Override
    public float translateToCommonUnits() {
        //we can convert the units here
        return this.validationValue;
    }

    @Override
    public ArrayList<String> getWarningList(float validationValue) {
        if(this.isMessageEnabled) {
            BoundryConditions boundryConditions = new BoundryConditions();
            return boundryConditions.getMessagesBasedOnValue(validationValue, "soc", "WARNING");
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getErrorList(float validationValue) {

        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "soc", "BREACH");
    }

    @Override
    public boolean batteryIsOk() {
        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "soc", "BREACH").isEmpty();
    }
}
