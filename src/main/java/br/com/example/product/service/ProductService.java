package br.com.example.product.service;

import br.com.example.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProductDtos();

    Optional<ProductDto> getProductDtoById(Long id);

    ProductDto createProductDto(ProductDto product);

    Optional<ProductDto> updateProductDto(Long id, ProductDto product);

    boolean deleteProductDto(Long id);
}