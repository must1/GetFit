package trainingapp.product.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeatCrudService {

    private final MeatRepository meatRepository;

    @Autowired
    public MeatCrudService(MeatRepository meatRepository) {
        this.meatRepository = meatRepository;
    }

    List<Meat> getAllMeat() {
        List<Meat> meats = new ArrayList<>();
        meatRepository.findAll().forEach(meats::add);
        return meats;
    }

    Meat createMeat(Meat newMeat) {
        if (newMeat != null) {
            return meatRepository.save(newMeat);
        } else {
            throw new IllegalArgumentException("Meat is null!");
        }
    }

    Meat deleteMeat(int id) {
        Meat meatToDelete = meatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fruit does not exist!"));
        meatRepository.delete(meatToDelete);
        return meatToDelete;
    }

    Meat updateMeat(Meat meatToUpdate) {
        return meatRepository.save(meatToUpdate);
    }

}
