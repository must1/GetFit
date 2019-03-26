package trainingapp.product.fruit;

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
class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String fruitName;
    double fatNumber;
    double proteinsNumber;
    double carbohydratesNumber;
    int kcal;

    public static class FruitBuilder {
        String fruitName;
        double fatNumber;
        double proteinsNumber;
        double carbohydratesNumber;
        int kcal;

        public FruitBuilder withName(String fruitName) {
            this.fruitName = fruitName;
            return this;
        }

        public FruitBuilder withKcal(int kcal) {
            this.kcal=kcal;
            return this;
        }

        public FruitBuilder withFatNumber(double fatNumber) {
            this.fatNumber = fatNumber;
            return this;
        }

        public FruitBuilder withProteinsNumber(double proteinsNumber) {
            this.proteinsNumber = proteinsNumber;
            return this;
        }

        public FruitBuilder withCarbohydratesNumber(double carbohydratesNumber) {
            this.carbohydratesNumber = carbohydratesNumber;
            return this;
        }

        public Fruit build() {
            Fruit fruit = new Fruit();
            fruit.carbohydratesNumber = this.carbohydratesNumber;
            fruit.fatNumber = this.fatNumber;
            fruit.proteinsNumber = this.proteinsNumber;
            fruit.fruitName = this.fruitName;
            fruit.kcal=this.kcal;
            return fruit;
        }
    }
}

