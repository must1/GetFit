package trainingapp.caloriescalculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesCalculationController {

    private final CaloriesCalculationFacade caloriesCalculationFacade;

    @Autowired
    public CaloriesCalculationController(CaloriesCalculationFacade caloriesCalculationFacade) {
        this.caloriesCalculationFacade = caloriesCalculationFacade;
    }

    @PostMapping("/countCalories")
    public String countCaloriesOfGivenProduct(@RequestBody ProductToCalculate productToCalculate) {
        return caloriesCalculationFacade.getMacroAndMicroElementsOfEatenProduct(productToCalculate);
    }
}
