package vitals;

import java.util.ArrayList;
import java.util.List;

public class StatusValidator implements Validator {

    List<Validator> validators;
    String local;

    public StatusValidator(List<Validator> validators, String local) {
        this.validators = validators;
        this.local = local;
    }


    @Override
    public float translateToCommonUnits() {
        return 0;
    }

    @Override
    public ArrayList<String> getWarningList(float validationValue) {
        return null;
    }

    @Override
    public ArrayList<String> getErrorList(float validationValue) {
        return null;
    }

    public ArrayList<String> replaceLocalizationValue(ArrayList<String> localizationKeys, String local) {
        Localizations localizations = new Localizations();
        return localizations.replaceLocalizationValue(localizationKeys, local);
    }

    public void printMessages(ArrayList<String> messages) {
        messages.forEach(System.out::println);
    }

    @Override
    public boolean batteryIsOk() {
        boolean validation = true;
        for (Validator validator : validators) {
            float validationValue = validator.translateToCommonUnits();
            ArrayList<String> warningList = validator.getWarningList(validationValue);
            ArrayList<String> errorList = validator.getErrorList(validationValue);
            warningList.addAll(errorList);
            warningList = replaceLocalizationValue(warningList, this.local);
            printMessages(warningList);
            validation = validation && validator.batteryIsOk();
        }
        return validation;
    }
}
