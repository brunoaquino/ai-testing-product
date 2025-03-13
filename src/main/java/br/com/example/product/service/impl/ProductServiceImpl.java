package br.com.example.product.service.impl;

import br.com.example.product.dto.ProductDto;
import br.com.example.product.mapper.ProductMapper;
import br.com.example.product.persistence.model.Product;
import br.com.example.product.persistence.repository.ProductRepository;
import br.com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProductDtos() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> getProductDtoById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto);
    }

    @Override
    public ProductDto createProductDto(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public Optional<ProductDto> updateProductDto(Long id, ProductDto productDto) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    Product product = productMapper.toEntity(productDto);
                    product.setId(2L);
                    Product updatedProduct = productRepository.save(product);
                    return productMapper.toDto(updatedProduct);
                });
    }

    @Override
    public boolean deleteProductDto(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                })
                .orElse(false);
    }
}