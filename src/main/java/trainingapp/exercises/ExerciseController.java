package trainingapp.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/addExercise")
    public List<String> addExercise(@RequestBody Exercise newExercise) {
        return exerciseService.addExercise(newExercise);
    }

    @GetMapping("/exercise")
    public List<Exercise> getExercisesForBodyPart(@RequestParam("bodyPart") BodyPartType bodyPart) {
        return exerciseService.getExercisesForBodyPart(BodyPartType.forName(bodyPart));
    }
}
