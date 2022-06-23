package vitals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoundryConditions {
    static Map<String, Map<String, String>> conditions;

    public static void setConditions() {
        conditions = new HashMap<>();
        Map<String, String> soc = new HashMap<>();
        soc.put("0-20", "LOW_SOC_BREACH");
        soc.put("21-24", "LOW_SOC_WARNING");
        soc.put("24-75", "NORMAL_SOC");
        soc.put("76-80", "HIGH_SOC_WARNING");
        soc.put("81-1000", "HIGH_SOC_BREACH");
        conditions.put("soc", soc);
        Map<String, String> tempRate = new HashMap<>();
        tempRate.put("0-0", "LOW_TEMP_BREACH");
        tempRate.put("1-2", "LOW_TEMP_WARNING");
        tempRate.put("2-42", "NORMAL_TEMP");
        tempRate.put("43-45", "HIGH_TEMP_WARNING");
        tempRate.put("46-100", "HIGH_TEMP_BREACH");
        conditions.put("temp", tempRate);

        Map<String, String> chargeRate = new HashMap<>();
        chargeRate.put("0-0", "LOW_CHARGE_RATE_BREACH");
        chargeRate.put("0.01-0.04", "LOW_CHARGE_RATE_WARNING");
        chargeRate.put("0.04-0.75", "NORMAL_CHARGE_RATE");
        chargeRate.put("0.76-0.8", "HIGH_CHARGE_RATE_WARNING");
        chargeRate.put("0.8-100", "HIGH_CHARGE_RATE_BREACH");
        conditions.put("chargeRate", chargeRate);
    }

    public ArrayList<String> getMessagesBasedOnValue(float value, String type, String messageType) {
        ArrayList<String> messages = new ArrayList<>();
        Double min, max;
        for (Map.Entry<String, String> hm : conditions.get(type).entrySet()) {
            if (hm.getValue().contains(messageType)) {
                min = Double.parseDouble(hm.getKey().split("-")[0]);
                max = Double.parseDouble(hm.getKey().split("-")[1]);
                if (value >= min && value <= max) {
                    messages.add(hm.getValue());
                    break;
                }
            }
        }
        return messages;
    }
}
