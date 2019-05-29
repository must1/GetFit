package trainingapp.historyofmealsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.userproduct.UserProductRepository;

import java.time.LocalDate;

@Service
public class HistorySystemService {

    private final UserProductRepository userProductRepository;

    @Autowired
    public HistorySystemService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    private double countFatOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        Double fatOfAllMealsWithDate = userProductRepository.countFatOfAllMealsByGivenID(userID, date);
        if (fatOfAllMealsWithDate == null)
            return 0;
        else {
            return fatOfAllMealsWithDate;
        }
    }

    private int countCaloriesOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        Integer caloriesOfAllMealsWithDate = userProductRepository.countCaloriesOfAllMealsByGivenIDInParticularDay(userID, date);
        if (caloriesOfAllMealsWithDate == null)
            return 0;
        else {
            return caloriesOfAllMealsWithDate;
        }
    }

    private double countCarbohydratesOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        Double carbohydratesOfAllMealsWithDate = userProductRepository.countCarbohydratesOfAllMealsByGivenID(userID, date);
        if (carbohydratesOfAllMealsWithDate == null)
            return 0;
        else {
            return carbohydratesOfAllMealsWithDate;
        }
    }

    private double countProteinsOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        Double proteinsOfAllMealsWithDate = userProductRepository.countProteinOfAllMealsByGivenID(userID, date);
        if (proteinsOfAllMealsWithDate == null)
            return 0;
        else {
            return proteinsOfAllMealsWithDate;
        }
    }

    public String getAllEatenSummedNutrientsByGivenIDInParticularDay(int userID, LocalDate date) {
        double sumOfFat = countFatOfAllMealsByGivenIDAndDate(userID, date);
        double sumOfProteins = countProteinsOfAllMealsByGivenIDAndDate(userID, date);
        double sumOfCarbohydrates = countCarbohydratesOfAllMealsByGivenIDAndDate(userID, date);
        int sumOfCalories = countCaloriesOfAllMealsByGivenIDAndDate(userID, date);

        return "Calculated calories: " + sumOfCalories +
                " Calculated fat: " + sumOfFat +
                " Calculated protein: " + sumOfProteins +
                " Calculated carbohydrates: " + sumOfCarbohydrates +
                ". All of these was eaten on " + date;
    }
}

