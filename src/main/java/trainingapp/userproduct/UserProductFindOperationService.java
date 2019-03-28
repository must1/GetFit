package trainingapp.userproduct;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProductFindOperationService {

    private final UserProductRepository userProductRepository;

    @Autowired
    UserProductFindOperationService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;

    }

    List<UserProduct> getAllUserProducts() {
        List<UserProduct> userProducts = new ArrayList<>();
        userProductRepository.findAll().forEach(userProducts::add);
        return userProducts;
    }
}
