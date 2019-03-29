package trainingapp.userproduct;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserProductRepository extends CrudRepository<UserProduct, Integer> {

    @Query("SELECT SUM(mealsWithGivenID.fatNumber) from UserProduct mealsWithGivenID WHERE :userID = mealsWithGivenID.userID AND :date = mealsWithGivenID.dateOfEatenProduct")
    Double countFatOfAllMealsByGivenID(@Param("userID") int userID, @Param("date") LocalDate date);

    @Query("SELECT SUM(mealsWithGivenID.proteinNumber) from UserProduct mealsWithGivenID WHERE :userID = mealsWithGivenID.userID")
    double countProteinOfAllMealsByGivenID(@Param("userID") int userID);

    @Query("SELECT SUM(mealsWithGivenID.carbohydratesNumber) from UserProduct mealsWithGivenID WHERE :userID = mealsWithGivenID.userID")
    double countCarbohydratesOfAllMealsByGivenID(@Param("userID") int userID);

    @Query("SELECT SUM(mealsWithGivenID.kcalNumber) from UserProduct mealsWithGivenID WHERE :userID = mealsWithGivenID.userID")
    double countCaloriesOfAllMealsByGivenIDInParticularDay(@Param("userID") int userID);
}
