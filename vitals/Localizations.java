package vitals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Localizations {
    static Map<String, Map<String, String>> localizations;


    public static void loadLocalizations() {
        localizations = new HashMap<>();
        Map<String, String> english = new HashMap<>();
        Map<String, String> german = new HashMap<>();
        english.put("LOW_SOC_BREACH", "BREACH::: ====> State of Charge is out of range!");
        english.put("LOW_SOC_WARNING", "WARNING::: ====> State of Charge is approaching for discharge!");
        english.put("NORMAL_SOC", "NORMAL::: ====> State of Charge is in range!");
        english.put("HIGH_SOC_WARNING", "WARNING::: ====> State of Charge is approaching for charge-peak!");
        english.put("HIGH_SOC_BREACH", "BREACH::: ====> State of Charge is out of range!");

        english.put("LOW_TEMP_BREACH", "BREACH::: ====> Temperature  is out of range!");
        english.put("LOW_TEMP_WARNING", "WARNING::: ====> Temperature  is approaching for breach!");
        english.put("NORMAL_TEMP", "NORMAL::: ====> Temperature  is in of range!");
        english.put("HIGH_TEMP_WARNING", "WARNING::: ====> Temperature  is approaching for breach!");
        english.put("HIGH_TEMP_BREACH", "BREACH::: ====> Temperature is out of range!");

        english.put("LOW_CHARGE_RATE_BREACH", "BREACH::: ====> Charge Rate  is out of range!");
        english.put("LOW_CHARGE_RATE_WARNING", "WARNING::: ====> Charge Rate is approaching for breach!");
        english.put("NORMAL_CHARGE_RATE", "NORMAL::: ====> SCharge Rate is in of range!");
        english.put("HIGH_CHARGE_RATE_WARNING", "WARNING::: ====> Charge Rate is approaching for breach!");
        english.put("HIGH_CHARGE_RATE_BREACH", "BREACH::: ====> Charge Rate is out of range!");

        localizations.put("en", english);
        german.put("LOW_SOC_BREACH", "BREACH::: ====> Der Ladezustand ist außerhalb des Bereichs!");
        german.put("LOW_SOC_WARNING", "WARNUNG::: ====> Der Ladezustand nähert sich einer Verletzung!");
        german.put("NORMAL_SOC", "NORMAL::: ====> Ladezustand ist in Reichweite!");
        german.put("HIGH_SOC_WARNING", "WARNUNG::: ====> Der Ladezustand nähert sich einer Verletzung!");
        german.put("HIGH_SOC_BREACH", "BREACH::: ====> Der Ladezustand ist außerhalb des Bereichs!");

        german.put("LOW_TEMP_BREACH", "BREACH::: ====> Temperatur außerhalb des zulässigen Bereichs!");
        german.put("LOW_TEMP_WARNING", "WARNUNG::: ====> Die Temperatur nähert sich dem Durchbruch!");
        german.put("NORMAL_TEMP", "NORMAL::: ====> Temperatur ist im Bereich!");
        german.put("HIGH_TEMP_WARNING", "WARNUNG::: ====> Die Temperatur nähert sich dem Durchbruch!");
        german.put("HIGH_TEMP_BREACH", "BREACH::: ====> Temperatur außerhalb des zulässigen Bereichs!");

        german.put("LOW_CHARGE_RATE_BREACH", "BREACH::: ====> Die Laderate ist außerhalb des zulässigen Bereichs!");
        german.put("LOW_CHARGE_RATE_WARNING", "WARNUNG::: ====> Die Laderate nähert sich der Verletzung!");
        german.put("NORMAL_CHARGE_RATE", "NORMAL::: ====> DISCharge Rate liegt im Bereich!");
        german.put("HIGH_CHARGE_RATE_WARNING", "WARNUNG::: ====> Die Laderate nähert sich der Verletzung!");
        german.put("HIGH_CHARGE_RATE_BREACH", "BREACH::: ====> Die Laderate ist außerhalb des zulässigen Bereichs!");
        localizations.put("de", german);
    }

    public ArrayList<String> replaceLocalizationValue(ArrayList<String> localizationKeys, String local) {
        ArrayList<String> localizationValues = new ArrayList<>();
        if (null == local || local.isEmpty()) local = "en";
        Map<String, String> localization = localizations.get(local);
        localizationKeys.forEach(key -> localizationValues.add(localization.get(key)));
        return localizationValues;
    }
}
