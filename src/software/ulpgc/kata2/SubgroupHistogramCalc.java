package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SubgroupHistogramCalc implements HistogramCalc{

    private final List<Food> foods;

    public SubgroupHistogramCalc(List<Food> foods) {
        this.foods = foods;
    }


    @Override
    public HashMap<String, Integer> calculate() {
        HashMap<String, Integer> result = new HashMap<>();
        Iterator<Food> var2 = this.foods.iterator();

        while (var2.hasNext()){
            Food food = var2.next();
            result.put(food.getSubgroup(), result.getOrDefault(food.getSubgroup(),0)+1);
        } return result;
    }
}
