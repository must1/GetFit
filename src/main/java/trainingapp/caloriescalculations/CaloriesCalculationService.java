package trainingapp.caloriescalculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingapp.product.fruit.Fruit;
import trainingapp.product.fruit.FruitRepository;
import trainingapp.product.meat.Meat;
import trainingapp.product.meat.MeatRepository;

@Service
public class CaloriesCalculationService {

    private final FruitRepository fruitRepository;
    private final MeatRepository meatRepository;

    @Autowired
    public CaloriesCalculationService(FruitRepository fruitRepository, MeatRepository meatRepository) {
        this.fruitRepository = fruitRepository;
        this.meatRepository = meatRepository;
    }

    //TODO
    int countFatNumberOfGivenProduct(produkt) {
        if (produkt.getClass == Meat.class)
            meatRepository.findById(produkt.getId);
        if (produkt.getClass == Fruit.class)
            fruitRepository.findById(produk.getId);
    }
}
