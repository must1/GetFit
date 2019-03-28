package trainingapp.userproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductCalculationFacade {

    private final UserProductCalculationService userProductCalculationService;

    @Autowired
    public UserProductCalculationFacade(UserProductCalculationService userProductCalculationService) {
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
