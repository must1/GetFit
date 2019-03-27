package trainingapp.account;

import lombok.*;
import trainingapp.product.Product;
import trainingapp.product.ProductType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;

    public static class AccountBuilder {
        String name;
        String password;


        public AccountBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.password = this.password;
            account.name = this.name;
            return account;
        }
    }
}
