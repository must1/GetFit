package trainingapp.exercises;

import java.util.InputMismatchException;

public enum BodyPartType {
    BACK, CHEST, BICEPS, TRICEPS;

    private static final BodyPartType[] copyOfValues = values();

    public static BodyPartType forName(BodyPartType name) {
        for (BodyPartType value : copyOfValues) {
            if (value.name().equals(String.valueOf(name))) {
                return value;
            }
        }
        throw new InputMismatchException("Given body part is bad!");
    }
}
