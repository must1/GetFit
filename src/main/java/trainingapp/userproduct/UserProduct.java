package trainingapp.userproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import trainingapp.account.Account;
import trainingapp.product.Product;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
class UserProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int gram;
    private double fatNumber;
    private double proteinNumber;
    private double carbohydratesNumber;
    private int kcalNumber;
    private LocalDateTime dateOfEatenProduct;
}
