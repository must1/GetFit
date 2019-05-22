package trainingapp.account;

import lombok.*;
import trainingapp.exercises.BodyPartType;

import javax.persistence.*;

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
    private BodyPartType favouriteBodyPart;

    public static class AccountBuilder {
        private String name;
        private String password;
        private BodyPartType favouriteBodyPart;

        public AccountBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withFavouritePartOfBody(BodyPartType favouriteBodyPart) {
            this.favouriteBodyPart = favouriteBodyPart;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.password = this.password;
            account.favouriteBodyPart = this.favouriteBodyPart;
            account.name = this.name;
            return account;
        }
    }
}
