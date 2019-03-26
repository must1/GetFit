package trainingapp.product.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitCrudController {

    private final FruitCrudService fruitCrudService;

    @Autowired
    public FruitCrudController(FruitCrudService fruitCrudService) {
        this.fruitCrudService = fruitCrudService;
    }

    @GetMapping("/fruit")
    public List<Fruit> getAllFruits() {
        return fruitCrudService.getAllFruits();
    }

    @PostMapping("/fruit")
    public Fruit createFruit(@RequestBody Fruit newFruit) {
        return fruitCrudService.createFruit(newFruit);
    }

    @DeleteMapping("/fruit")
    public Fruit deleteFruit(@RequestParam int id) {
        return fruitCrudService.deleteFruit(id);
    }

    @PutMapping("/fruit")
    public Fruit updateFruit(@RequestBody Fruit updatedFruit) {
        return fruitCrudService.updateFruit(updatedFruit);
    }
}
