package DataAccesPackage;

import Model.WaterMeterModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FakeDAO implements WaterMeterDAO {
    final Map<String, WaterMeterModel> database;

    public FakeDAO() {
        database = new HashMap<>();
        database.put("01.2018", new WaterMeterModel("", 3, 4));
       database.put("03.2018", new WaterMeterModel("", 2, 8));
        database.put("02.2018", new WaterMeterModel("", 9, 1));
    }


    @Override
    public int addNewWaterMeter() {
        System.out.print("Introdu luna: ");
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        System.out.print("Introdu apa rece: ");
        int coldWater = scanner.nextInt();
        System.out.print("Introdu apa calda: ");
        int hotWater = scanner.nextInt();
        database.put(month, new WaterMeterModel(month, hotWater, coldWater));
        return 1;
    }

    @Override
    public int deleteWaterMeter(String month) {
        database.remove(month);
        return 1;
    }

    @Override
    public void selectAllWater() {

        Map<String, WaterMeterModel> result = database.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        TreeMap<String, WaterMeterModel> treeMap = new TreeMap<String, WaterMeterModel>();
        treeMap.putAll(result);



        System.out.print("        ");
        for (String key : result.keySet()) {
            System.out.print("   " + key);
        }
        System.out.println("       Consum");
        System.out.print("\n Apa Calda  ");
        int sumHotWater=0;
        for (String key : result.keySet()) {
            sumHotWater += result.get(key).getHotWaterConsum();
            System.out.print(sumHotWater + "          ");
        }
        System.out.print(treeMap.lastEntry().getValue().getHotWaterConsum());
        System.out.print("\n Apa Rece   ");
        int sumColdWater=0;
        for (String key : result.keySet()) {
            sumColdWater += result.get(key).getColdWaterConsum();
            System.out.print(sumColdWater + "           ");
        }
        System.out.print(treeMap.lastEntry().getValue().getColdWaterConsum());

    }
}




