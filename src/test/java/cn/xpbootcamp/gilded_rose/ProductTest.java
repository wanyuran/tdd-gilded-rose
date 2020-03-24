package cn.xpbootcamp.gilded_rose;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {

    @Test
    void should_return_quality_no_less_than_0() {
        Product product = new Product(50,20,2);

        int quality = product.getCurrentQuality(30);

        assertTrue(quality >= 0);
    }

    @Test
    void should_return_quality_no_more_than_50() {
        Product product = new Product(50,30,5);

        int quality = product.getCurrentQuality(10);

        assertTrue(quality <= 50);
    }

    @Test
    void should_quality_of_many_days_passed_less_than_quality_of_few_days_passed() {
        Product product = new Product(50,20,2);

        int qualityOfManyDays = product.getCurrentQuality(30);
        int qualityOfFewDays = product.getCurrentQuality(10);

        assertTrue(qualityOfManyDays > qualityOfFewDays);
    }

    @Test
    void should_quality_no_change_for_Sulfuras_given_different_passed_days() {
        Product product = new Product(50,30,2,"Sulfuras");

        int qualityWithinSellIn = product.getCurrentQuality(30);
        int qualityOutOfSellIn = product.getCurrentQuality(70);

        assertTrue(qualityOutOfSellIn == qualityWithinSellIn);

    }

    @Test
    void should_quality_no_change_for_Aged_Brie_given_more_than_10_remaining_days() {
        Product product = new Product(50,30,2, "Aged Brie");

        int initialQuality = product.getInitialQuality();
        int quality = product.getCurrentQuality(11);

        assertTrue(quality == initialQuality);
    }

    @Test
    void should_quality_increase_by_2_for_Aged_Brie_given_less_than_10_and_more_than_5_remaining_days() { }

    @Test
    void should_quality_increase_by_3_for_Aged_Brie_given_less_than_5_and_more_than_0_remaining_days() { }

    @Test
    void should_quality_decrease_to_0_for_Aged_Brie_out_of_sellIn() {
        Product product = new Product(50, 30, 2, "Aged Brie");

        int quality = product.getCurrentQuality(51);

        assertEquals(0, quality);
    }


    @Test
    void should_quality_no_change_for_BackStage_Pass_given_more_than_10_remaining_days() {
        Product product = new Product(50,30,2,"BackStage Pass");

        int initialQuality = product.getInitialQuality();
        int quality = product.getCurrentQuality(11);

        assertTrue(quality == initialQuality);
    }

    @Test
    void should_quality_increase_by_2_for_BackStage_Pass_given_less_than_10_and_more_than_5_remaining_days() { }

    @Test
    void should_quality_increase_by_2_for_BackStage_Pass_given_less_than_5_and_more_than_0_remaining_days() { }

    @Test
    void should_quality_decrease_to_0_for_BackStage_Pass_out_of_sellIn() {
        Product product = new Product(50, 30, 2, "BackStage Pass");

        int quality = product.getCurrentQuality(51);

        assertEquals(0, quality);
    }

    @Test
    void should_quality_no_change_for_other_type_within_sellIn() {
        Product product = new Product(50,30,2,"others");

        int initialQuality = product.getInitialQuality();
        int qualityOutOfSellIn = product.getCurrentQuality(50);

        assertTrue(qualityOutOfSellIn == initialQuality);

    }

    @Test
    void should_quality_decease_by_twice_depreciation_for_other_type_out_of_sellIn() { }






}
