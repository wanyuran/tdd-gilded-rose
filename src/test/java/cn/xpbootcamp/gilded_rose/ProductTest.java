package cn.xpbootcamp.gilded_rose;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {

    @Test
    void should_return_quality_no_less_than_0_given_normal_type() {
        Product product = new Product(50,20,2,ProductType.NORMAL);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_less_than_0_given_Aged_Brie() {
        Product product = new Product(50,20,2,ProductType.AGED_BRIE);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_less_than_0_given_Backstage_Pass() {
        Product product = new Product(50,20,2,ProductType.BACKSTAGE_PASS);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_less_than_0_given_Sulfuras() {
        Product product = new Product(50,20,2,ProductType.SULFURAS);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_more_than_50_given_normal_type() {
        Product product = new Product(50,30,5, ProductType.NORMAL);

        int quality = product.getCurrentQuality(10);

        assertTrue(quality <= 50);
    }

    @Test
    void should_return_quality_no_more_than_50_given_Aged_Brie() {
        Product product = new Product(50,30,5, ProductType.AGED_BRIE);

        int quality = product.getCurrentQuality(10);

        assertTrue(quality <= 50);
    }

    @Test
    void should_return_quality_no_more_than_50_given_Backstage_Pass() {
        Product product = new Product(50,30,5, ProductType.BACKSTAGE_PASS);

        int quality = product.getCurrentQuality(10);

        assertTrue(quality <= 50);
    }

    @Test
    void should_return_quality_no_more_than_50_given_Sulfuras() {
        Product product = new Product(50,30,5, ProductType.SULFURAS);

        int quality = product.getCurrentQuality(10);

        assertTrue(quality <= 50);
    }

    @Test
    void should_quality_of_many_days_passed_less_than_quality_of_few_days_passed() {
        Product product = new Product(50,20,2, ProductType.NORMAL);

        int qualityOfManyDays = product.getCurrentQuality(30);
        int qualityOfFewDays = product.getCurrentQuality(10);

        assertTrue(qualityOfManyDays <= qualityOfFewDays);
    }

    @Test
    void should_quality_no_change_for_Sulfuras_given_different_passed_days() {
        Product product = new Product(50,30,2, ProductType.SULFURAS);

        int qualityWithinSellIn = product.getCurrentQuality(30);
        int qualityOutOfSellIn = product.getCurrentQuality(70);

        assertTrue(qualityOutOfSellIn == qualityWithinSellIn);

    }

    @Test
    void should_quality_no_change_for_Aged_Brie_given_more_than_10_left_days() {
        Product product = new Product(50,30,2, ProductType.SULFURAS);

        int initialQuality = product.getInitialQuality();
        int quality = product.getCurrentQuality(11);

        assertTrue(quality == initialQuality);
    }

    @Test
    void should_quality_increase_or_Aged_Brie_when_days_go_on_given_in_sell() {
        Product product = new Product(5, 30, 2, ProductType.AGED_BRIE);

        int quality = product.getCurrentQuality(1);

        assertEquals(32, quality);
    }

    @Test
    void should_quality_increase_or_Aged_Brie_when_days_go_on_given_out_of_sell() {
        Product product = new Product(5, 30, 2, ProductType.AGED_BRIE);

        int quality = product.getCurrentQuality(6);

        assertEquals(42, quality);
    }


    @Test
    void should_quality_no_change_for_BackStage_Pass_when_days_go_on_given_more_than_10_left_days() {
        Product product = new Product(50,30,2,ProductType.BACKSTAGE_PASS);

        int initialQuality = product.getInitialQuality();
        int quality = product.getCurrentQuality(39);

        assertTrue(quality == initialQuality);
    }

    @Test
    void should_quality_increase_by_2_for_BackStage_Pass_when_days_go_on_given_less_than_10_and_more_than_5_left_days() {
        Product product = new Product(50, 30, 5, ProductType.BACKSTAGE_PASS);

        int quality = product.getCurrentQuality(41);

        assertEquals(32 , quality);
    }

    @Test
    void should_quality_increase_by_2_for_BackStage_Pass_when_days_go_on_given_less_than_5_and_more_than_0_left_days() {
        Product product = new Product(50, 30, 5, ProductType.BACKSTAGE_PASS);

        int quality = product.getCurrentQuality(46);

        assertEquals(43, quality);
    }

    @Test
    void should_quality_decrease_to_0_for_BackStage_Pass_when_days_go_on_out_of_sellIn() {
        Product product = new Product(50, 30, 2, ProductType.BACKSTAGE_PASS);

        int quality = product.getCurrentQuality(51);

        assertEquals(0, quality);
    }

    @Test
    void should_quality_decrease_for_normal_type_when_days_go_on_within_sellIn() {
        Product product = new Product(5,30,2, ProductType.NORMAL);

        int initialQuality = product.getInitialQuality();
        int qualityOutOfSellIn = product.getCurrentQuality(4);

        assertEquals(22,qualityOutOfSellIn);
    }

    @Test
    void should_quality_decease_by_twice_depreciation_for_other_type_out_of_sellIn() {
        Product product = new Product(5, 30, 2, ProductType.NORMAL);

        int quality = product.getCurrentQuality(6);

        assertEquals(16, quality);
    }






}
