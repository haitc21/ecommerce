package ecommerce.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.entity.Category;
import ecommerce.product.entity.Product;
import ecommerce.product.exception.ProductException;
import ecommerce.product.mapper.ProductMapper;
import ecommerce.product.repository.CategoryRepository;
import ecommerce.product.repository.ProductRepository;
import ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private CategoryRepository categoryRepository;

    public ProductDto create(ProductRequestDto dto) throws ProductException {
        Product product = productMapper.toProduct(dto);
        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        if (category.isPresent()) {
            product.setCategory(category.get());
        }
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

    @Override
    public String delete(String productId) throws ProductException {
        Product product = findProductById(productId);
        productRepository.delete(product);
        return "Product deleted Successfully";
    }

    @Override
    public ProductDto update(String id, ProductRequestDto res) throws ProductException {
        Product product = findProductById(id);
        productMapper.updateProduct(product, res);
        if (product.getCategoryId() == null ? res.getCategoryId() != null : !product.getCategoryId().equals(res.getCategoryId())) {
            Optional<Category> category = categoryRepository.findById(res.getCategoryId());
            if (category.isPresent()) {
                product.setCategory(category.get());
            }
        }
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto findById(String id) throws ProductException {
        Product product = findProductById(id);
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> findByCategory(String category) {
        return productRepository
                .findByCategory(category)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDto> search(String query) {
        return productRepository
                .searchProduct(query)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public Page<ProductDto> filter(
            String categoryId,
            List<String> colors,
            List<String> sizes,
            Double minPrice,
            Double maxPrice,
            Integer minDiscount,
            String sort,
            Boolean isInStock,
            Integer pageNumber,
            Integer pageSize) {
        Sort.Direction sortDirection = "price_high".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC, "createDate")
                        .and(Sort.by(sortDirection, "price")));

        Page<Product> products = productRepository.filter(
                categoryId,
                colors,
                sizes,
                minPrice,
                maxPrice,
                minDiscount,
                isInStock,
                pageable);
        return products.map(productMapper::toDto);

    }

    @Override
    public List<ProductDto> recentlyAddedProduct() {
        return productRepository
                .findTop10ByOrderByCreatedDateDesc()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    private Product findProductById(String productId) throws ProductException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new ProductException("product not found with id " + productId);
        }
        return product.get();
    }
}
