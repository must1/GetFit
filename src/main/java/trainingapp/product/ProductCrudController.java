package trainingapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCrudController {

    private final ProductCrudService productCrudService;

    @Autowired
    public ProductCrudController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productCrudService.getAllProducts();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product newProduct) {
        return productCrudService.createProduct(newProduct);
    }

    @DeleteMapping("/product")
    public Product deleteProduct(@RequestParam int id) {
        return productCrudService.deleteProduct(id);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return productCrudService.updateProduct(updatedProduct);
    }
}
