package br.com.example.product.controller;

import br.com.example.product.dto.ProductDto;
import br.com.example.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProductDtos();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto product) {
        ProductDto createdProduct = productService.createProductDto(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto product) {
        return productService.updateProductDto(id, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProductDto(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
