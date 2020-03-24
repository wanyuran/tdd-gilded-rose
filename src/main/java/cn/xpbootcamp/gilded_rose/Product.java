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

    public Product(int sellIn, int initialQuality, String type) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
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

    public void setDepreciationPerDay(int depreciationPerDay, int passedDays) {
        int remainingDays = sellIn - passedDays;

        if (("Aged Brie".equals(type) || "Backstage pass".equals(type)) && remainingDays <= 10 && remainingDays > 5 ) {
            this.depreciationPerDay = 2;
        } else if(("Aged Brie".equals(type) || "Backstage pass".equals(type)) && remainingDays <= 5 && remainingDays >= 0) {
            this.depreciationPerDay = 3;
        }

        this.depreciationPerDay = depreciationPerDay;
    }

    public int getCurrentQuality(int passedDays) {
        int leftDays = sellIn - passedDays;

        if ("Aged Brie".equals(type) || "Backstage pass".equals(type)) {
            if (leftDays > 10) {
                int currentQuality = initialQuality;
                return currentQuality;
            } else if (leftDays > 5 && leftDays <= 10) {
                int currentQuality = Math.max(50, initialQuality + depreciationPerDay * (10 - leftDays));
                return currentQuality;
            } else if (leftDays >= 0 && leftDays <= 5) {
                int currentQuality = Math.max(50, initialQuality + depreciationPerDay * (5 - leftDays) + 10);
                return currentQuality;
            } else if (leftDays < 0) {
                int currentQuality = 0;
                return currentQuality;
            }
        } else if ("Sulfuras".equals(type)) {
            int currentQuality = initialQuality;
            return currentQuality;
        }

        int currentQuality = Math.min(0, initialQuality - leftDays * depreciationPerDay);
        return currentQuality;
    }
}
