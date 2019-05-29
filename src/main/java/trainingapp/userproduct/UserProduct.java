package trainingapp.userproduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public
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
    private LocalDate dateOfEatenProduct;

    public UserProduct(int userID, String name, int gram, double fatNumber) {
        this.userID = userID;
        this.name = name;
        this.gram = gram;
        this.fatNumber = fatNumber;
    }
}

