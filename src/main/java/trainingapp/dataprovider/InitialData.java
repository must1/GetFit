package trainingapp.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import trainingapp.product.Fruit;
import trainingapp.product.ProductRepository;

@Component
@Slf4j
public class InitialData {

    private final ProductRepository fruitRepository;

    @Autowired
    public InitialData(ProductRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addFruitsToDB() {
        log.info("Persisted fruit data to database");
        fruitRepository.save(new Fruit.FruitBuilder()
                .withName("Apple")
                .withCarbohydratesNumber(10.1)
                .withFatNumber(0.4)
                .withProteinsNumber(0.4)
                .withKcal(50)
                .build());

        fruitRepository.save(new Fruit.FruitBuilder()
                .withName("Orange")
                .withCarbohydratesNumber(12)
                .withFatNumber(0.1)
                .withProteinsNumber(0.9)
                .withKcal(47)
                .build());

        fruitRepository.save(new Fruit.FruitBuilder()
                .withName("Banana")
                .withCarbohydratesNumber(21.8)
                .withFatNumber(0.3)
                .withProteinsNumber(1)
                .withKcal(97)
                .build());

        fruitRepository.save(new Fruit.FruitBuilder()
                .withName("Strawberry")
                .withCarbohydratesNumber(5.8)
                .withFatNumber(0.4)
                .withProteinsNumber(0.7)
                .withKcal(33)
                .build());

        fruitRepository.save(new Fruit.FruitBuilder()
                .withName("Peach")
                .withCarbohydratesNumber(10)
                .withFatNumber(0.2)
                .withProteinsNumber(1)
                .withKcal(47)
                .build());
    }


}