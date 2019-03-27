package trainingapp.caloriescalculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.product.Product;
import trainingapp.product.ProductRepository;


@Service
public class CaloriesCalculationService {

    private final ProductRepository productRepository;

    @Autowired
    public CaloriesCalculationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //TODO
    int countFatNumberOfGivenProduct(Product product) {
        return 1;
    }
}
