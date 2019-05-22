package trainingapp.exercises;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public
class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BodyPartType bodyPartType;
    private String description;

    public static class ExerciseBuilder {
        private String name;
        private BodyPartType bodyPartType;
        private String description;

        public ExerciseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ExerciseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ExerciseBuilder withType(BodyPartType bodyPart) {
            this.bodyPartType = bodyPart;
            return this;
        }

        public Exercise build() {
            Exercise exercise = new Exercise();
            exercise.bodyPartType = this.bodyPartType;
            exercise.description = this.description;
            exercise.name = this.name;
            return exercise;
        }
    }
}
