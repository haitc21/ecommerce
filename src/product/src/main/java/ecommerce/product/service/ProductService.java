package ecommerce.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.entity.Product;
import ecommerce.product.mapper.ProductMapper;
import ecommerce.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto create(ProductRequestDto dto) {
        Product product = productMapper.toProduct(dto);
        productRepository.save(product);
        log.info("Create product successfully");
        return productMapper.toDto(product);
    }

    public List<ProductDto> getAll() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}
