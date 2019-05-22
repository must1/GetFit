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
    private String name;
    private double fatNumber;
    private double proteinNumber;
    private ProductType TYPE;
    private double carbohydratesNumber;
    private int kcalNumber;

    public static class ProductBuilder {
        String name;
        double fatNumber;
        ProductType TYPE;
        double proteinNumber;
        double carbohydratesNumber;
        int kcalNumber;

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withKcal(int kcal) {
            this.kcalNumber = kcal;
            return this;
        }

        public ProductBuilder withType(ProductType typeOfProduct) {
            this.TYPE = typeOfProduct;
            return this;
        }

        public ProductBuilder withFatNumber(double fatNumber) {
            this.fatNumber = fatNumber;
            return this;
        }

        public ProductBuilder withProteinsNumber(double proteinsNumber) {
            this.proteinNumber = proteinsNumber;
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
            product.proteinNumber = this.proteinNumber;
            product.name = this.name;
            product.TYPE = TYPE;
            product.kcalNumber = this.kcalNumber;
            return product;
        }
    }
}

