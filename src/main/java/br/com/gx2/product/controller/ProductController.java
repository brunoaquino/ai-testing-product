package br.com.gx2.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProductDtos() {
        return productService.getAllProductDtos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductDtoById(@PathVariable Long id) {
        return productService.getProductDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDto createProductDto(@RequestBody ProductDto product) {
        return productService.createProductDto(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductDto(@PathVariable Long id, @RequestBody ProductDto product) {
        return productService.updateProductDto(id, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductDto(@PathVariable Long id) {
        if (productService.deleteProductDto(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
