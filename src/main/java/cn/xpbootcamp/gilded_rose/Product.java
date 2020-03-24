package cn.xpbootcamp.gilded_rose;

public class Product {
    private int sellIn;
    private int initialQuality;
    private int depreciationPerDay;

    public  Product(int sellIn, int initialQuality, int depreciationPerDay){
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
        this.depreciationPerDay = depreciationPerDay;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getInitialQuality() {
        return initialQuality;
    }

    public void setInitialQuality(int initialQuality) {
        this.initialQuality = initialQuality;
    }

    public int getDepreciationPerDay() {
        return depreciationPerDay;
    }

    public void setDepreciationPerDay(int depreciationPerDay) {
        this.depreciationPerDay = depreciationPerDay;
    }

    public int getCurrentQuality(int passedDays) {
        int currentQuality = initialQuality - passedDays * depreciationPerDay;
        return Math.max(currentQuality,0);
    }
}
