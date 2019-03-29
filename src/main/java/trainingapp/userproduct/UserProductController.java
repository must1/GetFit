package trainingapp.userproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import trainingapp.calculations.NutrientsCalculationFacade;
import trainingapp.historysystemofmeals.HistorySystemService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserProductController {

    private final NutrientsCalculationFacade userProductCalculationFacade;
    private final UserProductFindOperationService userProductFindOperationService;
    private final HistorySystemService historySystemService;

    @Autowired
    public UserProductController(NutrientsCalculationFacade userProductCalculationFacade, UserProductFindOperationService userProductFindOperationService, HistorySystemService historySystemService) {
        this.userProductCalculationFacade = userProductCalculationFacade;
        this.userProductFindOperationService = userProductFindOperationService;
        this.historySystemService = historySystemService;
    }

    @PostMapping("/countNutrients")
    public String countNutrientsOfGivenProduct(@RequestBody UserProduct givenProductWithUserID) {
        return userProductCalculationFacade.getNutrientsOfGivenProductAndAddProductToUserProductDB(givenProductWithUserID);
    }

    @GetMapping("/userProducts")
    public List<UserProduct> getAllUserProducts() {
        return userProductFindOperationService.getAllUserProducts();
    }

    //yyyy-MM-dd
    @GetMapping("/userProducts/{userID}")
    public String getAllEatenSummedNutrientsByGivenIDInParticularDay(@PathVariable int userID,
                                                                     @RequestParam(value = "date")
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return historySystemService.getAllEatenSummedNutrientsByGivenIDInParticularDay(userID, date);
    }

}
