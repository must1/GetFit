package trainingapp.caloriescalculations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.product.Product;

@Service
public class CaloriesCalculationFacade {

    private final CaloriesCalculationService caloriesCalculationService;

    @Autowired
    public CaloriesCalculationFacade(CaloriesCalculationService caloriesCalculationService) {
        this.caloriesCalculationService = caloriesCalculationService;
    }

    public String getMacroAndMicroElementsOfEatenProduct(ProductToCalculate productToCalculate) {
        double calculatedFat = caloriesCalculationService.countFatNumberOfGivenProduct(productToCalculate);
        double calculatedProtein = caloriesCalculationService.countProteinNumberOfGivenProduct(productToCalculate);
        double calculatedCarbohydrates = caloriesCalculationService.countCarbohydratesNumberNumberOfGivenProduct(productToCalculate);
        int calculatedKcal = caloriesCalculationService.countCaloriesOfGivenProduct(productToCalculate);

        return "Calculated calories: " + calculatedKcal +
                " Calculated fat: " + calculatedFat +
                " Calculated protein: " + calculatedProtein +
                " Calculated carbohydrates: " + calculatedCarbohydrates;
    }
}
