package trainingapp.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import trainingapp.account.Account;
import trainingapp.account.AccountRepository;
import trainingapp.exercises.BodyPartType;
import trainingapp.exercises.Exercise;
import trainingapp.exercises.ExerciseRepository;
import trainingapp.product.Product;
import trainingapp.product.ProductRepository;
import trainingapp.product.ProductType;

@Component
@Slf4j
public class InitialData {

    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public InitialData(ProductRepository productRepository, AccountRepository accountRepository, ExerciseRepository exerciseRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addFruitsToDB() {
        log.info("Persisted fruit data to database");
        productRepository.save(new Product.ProductBuilder()
                .withName("Apple")
                .withCarbohydratesNumber(10.1)
                .withFatNumber(0.4)
                .withProteinsNumber(0.4)
                .withKcal(50)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Orange")
                .withCarbohydratesNumber(12)
                .withFatNumber(0.1)
                .withProteinsNumber(0.9)
                .withKcal(47)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Banana")
                .withCarbohydratesNumber(21.8)
                .withFatNumber(0.3)
                .withProteinsNumber(1)
                .withKcal(97)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Strawberry")
                .withCarbohydratesNumber(5.8)
                .withFatNumber(0.4)
                .withProteinsNumber(0.7)
                .withKcal(33)
                .withType(ProductType.FRUIT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Peach")
                .withCarbohydratesNumber(10)
                .withFatNumber(0.2)
                .withProteinsNumber(1)
                .withKcal(47)
                .withType(ProductType.FRUIT)
                .build());
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addMeatToDB() {
        log.info("Persisted meat data to database");

        productRepository.save(new Product.ProductBuilder()
                .withName("Chicken")
                .withCarbohydratesNumber(0)
                .withFatNumber(1.3)
                .withProteinsNumber(21.5)
                .withKcal(99)
                .withType(ProductType.MEAT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Turkey")
                .withCarbohydratesNumber(0)
                .withFatNumber(0.7)
                .withProteinsNumber(19.2)
                .withKcal(84)
                .withType(ProductType.MEAT)
                .build());

        productRepository.save(new Product.ProductBuilder()
                .withName("Schnitzel")
                .withCarbohydratesNumber(0)
                .withFatNumber(4.2)
                .withProteinsNumber(22.9)
                .withKcal(129)
                .withType(ProductType.MEAT)
                .build());
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addUsersToDB() {
        log.info("Persisted account data to database");

        accountRepository.save(new Account.AccountBuilder()
                .withName("user")
                .withPassword("123")
                .withFavouritePartOfBody(BodyPartType.BACK)
                .build());

        accountRepository.save(new Account.AccountBuilder()
                .withName("user2")
                .withPassword("1234")
                .withFavouritePartOfBody(BodyPartType.TRICEPS)
                .build());

        accountRepository.save(new Account.AccountBuilder()
                .withName("user3")
                .withPassword("12345")
                .withFavouritePartOfBody(BodyPartType.TRICEPS)
                .build());
    }


    @EventListener(ContextRefreshedEvent.class)
    public void addExercisesToDB() {
        log.info("Persisted exercises data to database");

        exerciseRepository.save(new Exercise.ExerciseBuilder()
                .withName("Triceps1")
                .withType(BodyPartType.TRICEPS)
                .withDescription("TricepsDescription1")
                .build());

        exerciseRepository.save(new Exercise.ExerciseBuilder()
                .withName("Back1")
                .withType(BodyPartType.BACK)
                .withDescription("BackDescritpion")
                .build());

        exerciseRepository.save(new Exercise.ExerciseBuilder()
                .withName("BICEPS1")
                .withType(BodyPartType.BICEPS)
                .withDescription("BicepsDescritpion")
                .build());
    }
}