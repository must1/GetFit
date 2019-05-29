package trainingapp.historyofmealsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import trainingapp.userproduct.UserProductRepository;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistorySystemServiceTest {

    @Mock
    UserProductRepository userProductRepository;

    @InjectMocks
    HistorySystemService historySystemService;

    @Test
    public void getAllEatenSummedNutrientsByGivenIDInParticularDay() {
        LocalDate localDate = LocalDate.of(2013, 1, 28);
        when(userProductRepository.countCaloriesOfAllMealsByGivenIDInParticularDay(1, localDate)).thenReturn(10);
        when(userProductRepository.countCarbohydratesOfAllMealsByGivenID(1, localDate)).thenReturn(10.0);
        when(userProductRepository.countProteinOfAllMealsByGivenID(1, localDate)).thenReturn(10.0);
        when(userProductRepository.countFatOfAllMealsByGivenID(1, localDate)).thenReturn(10.0);

        String expected = "Calculated calories: 10 Calculated fat: 10.0 Calculated protein: 10.0 Calculated carbohydrates: 10.0. All of these was eaten on 2013-01-28";
        String actual = historySystemService.getAllEatenSummedNutrientsByGivenIDInParticularDay(1, localDate);

        assertEquals(expected, actual);
    }
}