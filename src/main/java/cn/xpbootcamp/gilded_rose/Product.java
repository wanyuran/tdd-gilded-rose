package cn.xpbootcamp.gilded_rose;

public class Product {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private int sellIn;
    private int initialQuality;
    private int depreciationPerDay;
    private String type;

    public Product(int sellIn, int initialQuality, int depreciationPerDay) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
        this.depreciationPerDay = depreciationPerDay;
    }

    public Product(int sellIn, int initialQuality, int depreciationPerDay, String type) {
        this(sellIn, initialQuality, depreciationPerDay);
        this.type = type;
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
        int remainingDays = sellIn - passedDays;

        if ("Aged_Brie".equals(type) || "Backstage pass".equals(type)) {
            if (remainingDays > 10) {
                int currentQuality = initialQuality;
                return currentQuality;
            } else if (remainingDays > 5 && remainingDays <= 10) {
                int currentQuality = Math.max(50, initialQuality + 2 * (remainingDays - 5));
                return currentQuality;
            } else if (remainingDays >= 0 && remainingDays <= 5) {
                int currentQuality = Math.max(50, initialQuality + 3 * remainingDays + 20);
                return currentQuality;
            } else if (remainingDays < 0) {
                int currentQuality = 0;
                return currentQuality;
            }
        } else if ("Sulfuras".equals(type)) {
            int currentQuality = initialQuality;
            return currentQuality;
        }

        int currentQuality = Math.min(0, initialQuality - remainingDays * depreciationPerDay);
        return currentQuality;
    }
}
