package trainingapp.calculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.account.AccountRepository;
import trainingapp.product.Product;
import trainingapp.product.ProductRepository;
import trainingapp.userproduct.UserProduct;
import trainingapp.userproduct.UserProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NutrientsCalculationService {

    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final UserProductRepository userProductRepository;
    private static final int ONE_HUNDRED_GRAMS = 100;

    @Autowired
    public NutrientsCalculationService(UserProductRepository userProductRepository, ProductRepository productRepository, AccountRepository accountRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.userProductRepository = userProductRepository;
    }

    double countFatNumberOfGivenProduct(UserProduct productToCalculate) {
        double fatNumber = retrieveGivenProductFromDB(productToCalculate).getFatNumber(); // All given data in DB are per 100g!!!
        return (fatNumber * productToCalculate.getGram()) / ONE_HUNDRED_GRAMS;
    }

    double countProteinNumberOfGivenProduct(UserProduct productToCalculate) {
        double proteinNumber = retrieveGivenProductFromDB(productToCalculate).getProteinNumber(); // All given data in DB are per 100g!!!
        return (proteinNumber * productToCalculate.getGram()) / ONE_HUNDRED_GRAMS;
    }

    double countCarbohydratesNumberNumberOfGivenProduct(UserProduct productToCalculate) {
        double carbohydratesNumber = retrieveGivenProductFromDB(productToCalculate).getCarbohydratesNumber(); // All given data in DB are per 100g!!!
        return (carbohydratesNumber * productToCalculate.getGram()) / ONE_HUNDRED_GRAMS;
    }

    int countCaloriesOfGivenProduct(UserProduct productToCalculate) {
        int kcalNumber = retrieveGivenProductFromDB(productToCalculate).getKcalNumber();
        return (kcalNumber * productToCalculate.getGram()) / ONE_HUNDRED_GRAMS;
    }

    private Product retrieveGivenProductFromDB(UserProduct productToCalculate) {
        if (productToCalculate.getGram() > 0) {
            return productRepository.findByName(productToCalculate.getName())
                    .orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        } else {
            throw new IllegalArgumentException("Grams can not be negative");
        }
    }

    private boolean checkIfGivenAccountExist(UserProduct givenIDOfUser) {
        return accountRepository.doesAccountExistsWithGivenID(givenIDOfUser.getUserID());
    }

    void addGivenProductToGivenUserInDB(UserProduct givenProductWithUserID, double calculatedFat, double calculatedProtein, double calculatedCarbohydrates, int calculatedKcal) {
        if (checkIfGivenAccountExist(givenProductWithUserID)) {

            UserProduct userProduct = new UserProduct();
            userProduct.setDateOfEatenProduct(LocalDate.now());
            userProduct.setCarbohydratesNumber(calculatedCarbohydrates);
            userProduct.setFatNumber(calculatedFat);
            userProduct.setProteinNumber(calculatedProtein);
            userProduct.setKcalNumber(calculatedKcal);
            userProduct.setUserID(givenProductWithUserID.getUserID());

            userProductRepository.save(userProduct);
        } else {
            throw new IllegalArgumentException("Account does not exist with given ID!");
        }
    }


}
