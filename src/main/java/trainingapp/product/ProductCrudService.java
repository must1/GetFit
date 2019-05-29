package trainingapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCrudService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductCrudService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    Product createProduct(Product newProduct) {
        if (newProduct != null) {
            return productRepository.save(newProduct);
        } else {
            throw new IllegalArgumentException("Product is null!");
        }
    }

    Product deleteProduct(int id) {
        Product productToDelete = productRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product does not exist!"));
        productRepository.delete(productToDelete);
        return productToDelete;
    }

    Product updateProduct(Product productToUpdate) {
        return productRepository.save(productToUpdate);
    }
}
