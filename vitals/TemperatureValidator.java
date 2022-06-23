package vitals;

import java.util.ArrayList;

public class TemperatureValidator implements Validator {

    float validationValue;
    String unitType;
    boolean isMessageEnabled;


    public TemperatureValidator(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }

    @Override
    public float translateToCommonUnits() {
        if (this.unitType.equals("Fahrenheit")) return this.validationValue;
        else if (this.unitType.equals("Celsius")) return ((this.validationValue * 9) / 5) + 32;
        return this.validationValue;
    }

    @Override
    public ArrayList<String> getWarningList(float validationValue) {
        if(this.isMessageEnabled){
            BoundryConditions boundryConditions = new BoundryConditions();
            return boundryConditions.getMessagesBasedOnValue(validationValue, "temp", "WARNING");
        }
       return  new ArrayList<>();
    }

    @Override
    public ArrayList<String> getErrorList(float validationValue) {
        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "temp", "BREACH");
    }

    @Override
    public boolean batteryIsOk() {
        BoundryConditions boundryConditions = new BoundryConditions();
        return boundryConditions.getMessagesBasedOnValue(validationValue, "temp", "BREACH").isEmpty();
    }
}
