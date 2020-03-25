package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;

public class Product {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private int sellIn;
    private int initialQuality;
    private int depreciationPerDay;
    private ProductType type;

    public Product(int sellIn, int initialQuality, int depreciationPerDay, ProductType type) {
        this.sellIn = sellIn;
        this.initialQuality = initialQuality;
        this.depreciationPerDay = depreciationPerDay;
        this.type = type;
    }

    public int getInitialQuality() {
        return initialQuality;
    }

    public int qualityChangePerDay(int passedDays) {
        int leftDays = sellIn - passedDays;
        switch (type) {
            case BACKSTAGE_PASS:
                if (leftDays > 5 && leftDays <= 10) {
                    return 2;
                } else if (leftDays >= 0 && leftDays <= 5) {
                    return 3;
                }
                break;
            case NORMAL:
                if (leftDays >= 0) {
                    return depreciationPerDay;
                } else {
                    return 2 * depreciationPerDay;
                }
        }
        return depreciationPerDay;
    }

    public int getCurrentQuality(int passedDays) {
        int leftDays = sellIn - passedDays;

        switch (type) {
            case BACKSTAGE_PASS:
                if (leftDays > 10) {
                    return initialQuality;
                } else if (leftDays > 5) {
                    return Math.min(MAX_QUALITY, initialQuality + this.qualityChangePerDay(passedDays) * (10 - leftDays));
                } else if (leftDays >= 0) {
                    return Math.min(MAX_QUALITY, initialQuality + this.qualityChangePerDay(passedDays) * (5 - leftDays) + 10);
                } else {
                    return 0;
                }
            case AGED_BRIE:
                return Math.min(MAX_QUALITY, initialQuality + this.qualityChangePerDay(passedDays) * passedDays);
            case SULFURAS:
                return initialQuality;
            case NORMAL:
                if (leftDays >= 0) {
                    return Math.max(MIN_QUALITY, initialQuality - this.qualityChangePerDay(passedDays) * passedDays);
                } else {
                    return Math.max(MIN_QUALITY, initialQuality - this.qualityChangePerDay(sellIn) * sellIn + this.qualityChangePerDay(passedDays) * leftDays);
                }
        }
        return 0;
    }
}


//        if ("Backstage Pass".equals(type)) {
//            if (leftDays > 10) {
//                return initialQuality;
//            } else if (leftDays > 5 && leftDays <= 10) {
//                return Math.min(50, initialQuality + this.qualityChangePerDay(passedDays) * (10 - leftDays));
//            } else if (leftDays >= 0 && leftDays <= 5) {
//                return Math.min(50, initialQuality + this.qualityChangePerDay(passedDays) * (5 - leftDays) + 10);
//            } else if (leftDays < 0) {
//                return 0;
//            }
//        }
//
//        if ("Sulfuras".equals(type)) {
//            return initialQuality;
//        }
//
//        if ("Aged Brie".equals(type) && leftDays >= 0) {
//            return Math.min(50, initialQuality + this.qualityChangePerDay(passedDays) * leftDays);
//        } else if ("Aged Brie".equals(type) && leftDays < 0) {
//            return Math.min(50, initialQuality + this.qualityChangePerDay(passedDays) * (sellIn - leftDays));
//        }
//
//        if (!(Arrays.asList(specialProduct).contains(type)) && leftDays >= 0) {
//            return Math.max(0, initialQuality - this.qualityChangePerDay(passedDays) * passedDays);
//        } else if (!(Arrays.asList(specialProduct).contains(type)) && leftDays < 0) {
//            return Math.max(0, initialQuality - this.qualityChangePerDay(sellIn) * sellIn + this.qualityChangePerDay(passedDays) * leftDays);
//        }
//
//        return 0;
//    }
//}
//
//class NormalProduct extends Product {
//    public NormalProduct(int sellIn, int initialQuality, int depreciationPerDay) {
//        super(int sellIn, int initialQuality, int depreciationPerDay)
//    }
//}
//
//class OtherProduct extends Product {
//
//}
