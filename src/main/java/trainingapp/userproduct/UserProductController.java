package trainingapp.userproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProductController {

    private final UserProductCalculationFacade caloriesCalculationFacade;
    private final UserProductFindOperationService userProductFindOperationService;


    @Autowired
    public UserProductController(UserProductCalculationFacade caloriesCalculationFacade, UserProductFindOperationService userProductFindOperationService) {
        this.caloriesCalculationFacade = caloriesCalculationFacade;
        this.userProductFindOperationService = userProductFindOperationService;
    }

    @PostMapping("/countNutrients")
    public String countNutrientsOfGivenProduct(@RequestBody UserProduct givenProductWithUserID) {
        return caloriesCalculationFacade.getNutrientsOfGivenProductAndAddProductToUserProductDB(givenProductWithUserID);
    }

    @GetMapping("/userProducts")
    public List<UserProduct> getAllUserProducts() {
        return userProductFindOperationService.getAllUserProducts();
    }

}
