package ra.btvn06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.btvn06.entity.Product;
import ra.btvn06.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsJson() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/products/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Product>> getProductsXml() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
