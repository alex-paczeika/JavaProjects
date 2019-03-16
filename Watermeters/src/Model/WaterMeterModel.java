package Model;

public class WaterMeterModel {

    private String month;
    private int hotWaterConsum;
    private int coldWaterConsum;


    public WaterMeterModel(String month, int hotWaterConsum, int coldWaterConsum) {
        this.month = month;
        this.hotWaterConsum = hotWaterConsum;
        this.coldWaterConsum = coldWaterConsum;
    }

    public String getMonth() {
        return month;
    }

    public int getHotWaterConsum() {
        return hotWaterConsum;
    }

    public int getColdWaterConsum() {
        return coldWaterConsum;
    }
}
