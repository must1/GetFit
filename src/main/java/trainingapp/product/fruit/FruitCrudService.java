package trainingapp.product.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitCrudService {

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitCrudService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    List<Fruit> getAllFruits() {
        List<Fruit> fruits = new ArrayList<>();
        fruitRepository.findAll().forEach(fruits::add);
        return fruits;
    }

    Fruit createFruit(Fruit newFruit) {
        if (newFruit != null) {
            return fruitRepository.save(newFruit);
        } else {
            throw new IllegalArgumentException("Fruit is null!");
        }
    }

    Fruit deleteFruit(int id) {
        Fruit fruitToDelete = fruitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fruit does not exist!"));
        fruitRepository.delete(fruitToDelete);
        return fruitToDelete;
    }

    Fruit updateFruit(Fruit fruitToUpdate) {
        return fruitRepository.save(fruitToUpdate);
    }

}
