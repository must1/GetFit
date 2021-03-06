package trainingapp.userproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProductFindOperationService {

    private final UserProductRepository userProductRepository;

    @Autowired
    UserProductFindOperationService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    List<UserProduct> getAllUsersProducts() {
        List<UserProduct> userProducts = new ArrayList<>();
        userProductRepository.findAll().forEach(userProducts::add);
        return userProducts;
    }
}
