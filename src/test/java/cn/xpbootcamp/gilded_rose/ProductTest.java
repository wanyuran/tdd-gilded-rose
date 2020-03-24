package cn.xpbootcamp.gilded_rose;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
