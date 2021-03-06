package trainingapp.calculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.userproduct.UserProduct;

@Service
public class NutrientsCalculationFacade {

    private final NutrientsCalculationService userProductCalculationService;

    @Autowired
    public NutrientsCalculationFacade(NutrientsCalculationService userProductCalculationService) {
        this.userProductCalculationService = userProductCalculationService;
    }

    public String getNutrientsOfGivenProductAndAddProductToUserProductDB(UserProduct givenProductWithUserID) {
        double calculatedFat = userProductCalculationService.countFatNumberOfGivenProduct(givenProductWithUserID);
        double calculatedProtein = userProductCalculationService.countProteinNumberOfGivenProduct(givenProductWithUserID);
        double calculatedCarbohydrates = userProductCalculationService.countCarbohydratesNumberNumberOfGivenProduct(givenProductWithUserID);
        int calculatedKcal = userProductCalculationService.countCaloriesOfGivenProduct(givenProductWithUserID);

        userProductCalculationService.addGivenProductToGivenUserInDB(givenProductWithUserID, calculatedFat,
                calculatedProtein, calculatedCarbohydrates, calculatedKcal);

        return "Calculated calories: " + calculatedKcal +
                " Calculated fat: " + calculatedFat +
                " Calculated protein: " + calculatedProtein +
                " Calculated carbohydrates: " + calculatedCarbohydrates;
    }
}
