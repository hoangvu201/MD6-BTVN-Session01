package ra.btvn06.service.impl;

import org.springframework.stereotype.Service;
import ra.btvn06.entity.Product;
import ra.btvn06.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "Laptop Dell XPS", 1200.5),
            new Product(2L, "iPhone 15", 1500.0)
    );

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
