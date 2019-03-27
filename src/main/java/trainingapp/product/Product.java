package trainingapp.product;

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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    double fatNumber;
    double proteinsNumber;
    double carbohydratesNumber;
    int kcal;

    public static class ProductBuilder {
        String name;
        double fatNumber;
        double proteinsNumber;
        double carbohydratesNumber;
        int kcal;

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withKcal(int kcal) {
            this.kcal = kcal;
            return this;
        }

        public ProductBuilder withFatNumber(double fatNumber) {
            this.fatNumber = fatNumber;
            return this;
        }

        public ProductBuilder withProteinsNumber(double proteinsNumber) {
            this.proteinsNumber = proteinsNumber;
            return this;
        }

        public ProductBuilder withCarbohydratesNumber(double carbohydratesNumber) {
            this.carbohydratesNumber = carbohydratesNumber;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.carbohydratesNumber = this.carbohydratesNumber;
            product.fatNumber = this.fatNumber;
            product.proteinsNumber = this.proteinsNumber;
            product.name = this.name;
            product.kcal = this.kcal;
            return product;
        }
    }
}

