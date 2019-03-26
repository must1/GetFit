package trainingapp.product.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeatCrudController {

    private final MeatCrudService meatCrudService;

    @Autowired
    public MeatCrudController(MeatCrudService fruitCrudService) {
        this.meatCrudService = fruitCrudService;
    }

    @GetMapping("/meat")
    public List<Meat> getAllFruits() {
        return meatCrudService.getAllMeat();
    }

    @PostMapping("/meat")
    public Meat createMeat(@RequestBody Meat newMeat) {
        return meatCrudService.createMeat(newMeat);
    }

    @DeleteMapping("/meat")
    public Meat deleteMeat(@RequestParam int id) {
        return meatCrudService.deleteMeat(id);
    }

    @PutMapping("/meat")
    public Meat updateMeat(@RequestBody Meat updatedMeat) {
        return meatCrudService.updateMeat(updatedMeat);
    }
}
