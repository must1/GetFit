package trainingapp.calculations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import trainingapp.account.AccountRepository;
import trainingapp.product.Product;
import trainingapp.product.ProductRepository;
import trainingapp.product.ProductType;
import trainingapp.userproduct.UserProduct;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NutrientsCalculationServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private NutrientsCalculationService nutrientsCalculationService;

    @Test
    public void countFatNumberOfGivenProduct() {
        UserProduct userProduct = createDummyUserProduct();
        Product product = createDummyProduct();
        when(productRepository.findByName(userProduct.getName())).thenReturn(Optional.of(product));

        double expectedFatNumber = nutrientsCalculationService.countFatNumberOfGivenProduct(userProduct);
        double actualFatNumber = product.getFatNumber() * userProduct.getGram() / 100;

        assertEquals(expectedFatNumber, actualFatNumber, 0.0002);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrieveGivenProductWhenGramsAreNegative() {
        UserProduct userProduct = createDummyUserProduct();
        userProduct.setGram(-100);

        nutrientsCalculationService.retrieveGivenProductFromDB(userProduct);
    }

    private UserProduct createDummyUserProduct() {
        return new UserProduct(1, "Schnitzel", 129, 4.2);
    }

    private Product createDummyProduct() {
        return new Product.ProductBuilder()
                .withName("Schnitzel")
                .withCarbohydratesNumber(0)
                .withFatNumber(4.2)
                .withProteinsNumber(22.9)
                .withKcal(129)
                .withType(ProductType.MEAT)
                .build();
    }

}