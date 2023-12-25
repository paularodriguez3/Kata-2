package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<Food> foods = CsvFoodLoader.with("dataset.csv").load();
        HashMap<String, Integer> histogram = new SubgroupHistogramCalc(foods).calculate();
        Iterator<String> var3 = histogram.keySet().stream().toList().iterator();

        while (var3.hasNext()){
            String key = var3.next();
            System.out.println(ket + "->" + histogram.get(key));
        }
    }
}
