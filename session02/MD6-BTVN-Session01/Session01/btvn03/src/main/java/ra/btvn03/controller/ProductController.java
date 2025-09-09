package ra.btvn03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ra.btvn03.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1L, "Laptop Dell XPS", 1200.50),
                    new Product(2L, "Laptop HP Envy", 1000.00),
                    new Product(3L, "iPhone 15", 1500.00),
                    new Product(4L, "Samsung Galaxy S23", 1300.00),
                    new Product(5L, "Xiaomi Redmi Note", 500.00)
            )
    );

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
