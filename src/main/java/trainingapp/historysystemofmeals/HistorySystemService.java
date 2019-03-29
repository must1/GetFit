package trainingapp.historysystemofmeals;

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
        if (userProductRepository.countFatOfAllMealsByGivenID(userID, date) == null)
            return 0;
        else {
            return userProductRepository.countFatOfAllMealsByGivenID(userID, date);
        }
    }

    private int countCaloriesOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        if (userProductRepository.countFatOfAllMealsByGivenID(userID, date) == null)
            return 0;
        else {
            return userProductRepository.countCaloriesOfAllMealsByGivenIDInParticularDay(userID, date);
        }
    }

    private double countCarbohydratesOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        if (userProductRepository.countFatOfAllMealsByGivenID(userID, date) == null)
            return 0;
        else {
            return userProductRepository.countCarbohydratesOfAllMealsByGivenID(userID, date);
        }
    }

    private double countProteinsOfAllMealsByGivenIDAndDate(int userID, LocalDate date) {
        if (userProductRepository.countFatOfAllMealsByGivenID(userID, date) == null)
            return 0;
        else {
            return userProductRepository.countProteinOfAllMealsByGivenID(userID, date);
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

