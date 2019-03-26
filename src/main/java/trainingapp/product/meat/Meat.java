package trainingapp.product.meat;

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
public class Meat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String meatName;
    double fatNumber;
    double proteinsNumber;
    double carbohydratesNumber;
    int kcal;

    public static class MeatBuilder {
        String meatName;
        double fatNumber;
        double proteinsNumber;
        double carbohydratesNumber;
        int kcal;

        public MeatBuilder withName(String meatName) {
            this.meatName = meatName;
            return this;
        }

        public MeatBuilder withKcal(int kcal) {
            this.kcal = kcal;
            return this;
        }

        public MeatBuilder withFatNumber(double fatNumber) {
            this.fatNumber = fatNumber;
            return this;
        }

        public MeatBuilder withProteinsNumber(double proteinsNumber) {
            this.proteinsNumber = proteinsNumber;
            return this;
        }

        public MeatBuilder withCarbohydratesNumber(double carbohydratesNumber) {
            this.carbohydratesNumber = carbohydratesNumber;
            return this;
        }

        public Meat build() {
            Meat fruit = new Meat();
            fruit.carbohydratesNumber = this.carbohydratesNumber;
            fruit.fatNumber = this.fatNumber;
            fruit.proteinsNumber = this.proteinsNumber;
            fruit.meatName = this.meatName;
            fruit.kcal = this.kcal;
            return fruit;
        }
    }
}

