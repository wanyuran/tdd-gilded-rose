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

}
