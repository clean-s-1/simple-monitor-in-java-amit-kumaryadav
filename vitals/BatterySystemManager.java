package vitals;

import java.util.Arrays;

public class BatterySystemManager {
    boolean batteryIsOk(SystemInput temperatureInput, SystemInput socInput, SystemInput chargeRateInput, String local) {
        TemperatureValidator temperatureValidatorComposite = new TemperatureValidator(temperatureInput.validationValue, temperatureInput.unitType, temperatureInput.isMessageEnabled);
        SocValidator socValidatorComposite = new SocValidator(socInput.validationValue, socInput.unitType, socInput.isMessageEnabled);
        ChargeRateValidator chargeRateValidatorComposite = new ChargeRateValidator(chargeRateInput.validationValue, chargeRateInput.unitType, chargeRateInput.isMessageEnabled);
        return new StatusValidator(Arrays.asList(temperatureValidatorComposite, socValidatorComposite, chargeRateValidatorComposite), local).batteryIsOk();
    }

    public static void main(String[] args) {
        BatterySystemManager bsm = new BatterySystemManager();
        Localizations.loadLocalizations();
        BoundryConditions.setConditions();
        assert (bsm.batteryIsOk(new SystemInput(47, FAHRENHEIT_CONST, true), new SystemInput(77, null, true), new SystemInput(0.9f, null, true), "de") == false);
        assert (bsm.batteryIsOk(new SystemInput(8.33f, CELSIUS_CONST, true), new SystemInput(77, null, true), new SystemInput(0.9f, null, true), "en") == false);

        assert (bsm.batteryIsOk(new SystemInput(25, FAHRENHEIT_CONST, true), new SystemInput(70, null, true), new SystemInput(0.7f, null, true), "de") == true);
        assert (bsm.batteryIsOk(new SystemInput(0, FAHRENHEIT_CONST, true), new SystemInput(80, null, true), new SystemInput(0.80f, null, true), "en") == false);
        assert (bsm.batteryIsOk(new SystemInput(20, FAHRENHEIT_CONST, true), new SystemInput(50, null, true), new SystemInput(0.60f, null, true), "en") == true);
    }

    static String FAHRENHEIT_CONST = "Fahrenheit";
    static String CELSIUS_CONST = "Celsius";
}