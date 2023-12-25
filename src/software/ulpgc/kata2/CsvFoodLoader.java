package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFoodLoader implements FoodLoader{

    private final File file;

    public CsvFoodLoader(File file) {
        this.file = file;
    }

    public static FoodLoader with(String file){
        return new CsvFoodLoader(new File(file));
    }

    @Override
    public List<Food> load() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            List var2;
            try {
                var2 = this.load(reader);
            }  catch (Throwable var5){
                try{
                    reader.close();
                } catch (Throwable var4){
                    var5.addSuppressed(var4);
                }
                throw var5;
            }
            reader.close();
            return var2;
        } catch (IOException e){
            return Collections.emptyList();
        }
    }

    private List load(BufferedReader reader) {
        return reader.lines().skip(1L).map(this::toFood).collect(Collectors.toList());
    }

    private Object toFood(String line) {
        return this.toFood(line.split(","));
    }

    private Object toFood(String[] fields) {
        return new Food(fields[0],fields[1],fields[2],fields[3]);
    }
}
