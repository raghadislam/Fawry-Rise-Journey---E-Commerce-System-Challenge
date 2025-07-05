package Service;

import Interface.IShippable;
import Utils.FormatterUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ShippingService {

    public void ship(List<IShippable> items) {
        System.out.println("********** Shipment notice **********");

        Map<String, Double> totalWeightByName = new LinkedHashMap<>();

        for (IShippable item : items) {
            String name = item.getName();
            totalWeightByName.put(name, totalWeightByName.getOrDefault(name, 0.0) + item.getWeight());
        }

        double totalWeight = 0;
        for (String name : totalWeightByName.keySet()) {
            double weight = totalWeightByName.get(name);
            System.out.printf("%-12s %s\n", name, FormatterUtil.formatWeight(weight));
            totalWeight += weight;
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
