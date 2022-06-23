package vitals;

import java.util.ArrayList;

public interface Validator {

    float translateToCommonUnits();

    ArrayList<String> getWarningList(float validationValue);

    ArrayList<String> getErrorList(float validationValue);

    boolean batteryIsOk();

}
