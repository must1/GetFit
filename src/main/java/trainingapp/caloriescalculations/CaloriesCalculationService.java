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

    double countFatNumberOfGivenProduct(ProductToCalculate productToCalculate) {
        double fatNumber = retrieveProductFromDB(productToCalculate).getFatNumber(); // All given data in DB are per 100g!!!
        return (fatNumber * productToCalculate.getGram()) / 100;
    }

    double countProteinNumberOfGivenProduct(ProductToCalculate productToCalculate) {
        double proteinNumber = retrieveProductFromDB(productToCalculate).getProteinNumber(); // All given data in DB are per 100g!!!
        return (proteinNumber * productToCalculate.getGram()) / 100;
    }

    double countCarbohydratesNumberNumberOfGivenProduct(ProductToCalculate productToCalculate) {
        double carbohydratesNumber = retrieveProductFromDB(productToCalculate).getCarbohydratesNumber(); // All given data in DB are per 100g!!!
        return (carbohydratesNumber * productToCalculate.getGram()) / 100;
    }

    int countCaloriesOfGivenProduct(ProductToCalculate productToCalculate) {
        int kcalNumber = retrieveProductFromDB(productToCalculate).getKcalNumber();
        return (kcalNumber * productToCalculate.getGram()) / 100;
    }

    private Product retrieveProductFromDB(ProductToCalculate productToCalculate) {
        if (productToCalculate.getGram() > 0) {
            return productRepository.findByName(productToCalculate.getName())
                    .orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        } else {
            throw new IllegalArgumentException("Calories can not be negative");
        }

    }


}
