package ecommerce.product.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.exception.ProductException;

public interface ProductService {

    public ProductDto create(ProductRequestDto req) throws ProductException;

    public String delete(String productId) throws ProductException;

    public ProductDto update(String id, ProductRequestDto dto) throws ProductException;

    public List<ProductDto> getAll();

    public ProductDto findById(String id) throws ProductException;

    public List<ProductDto> findByCategory(String category);

    public List<ProductDto> search(String query);

    public Page<ProductDto> filter(String category, List<String> colors, List<String> sizes, Double minPrice, Double maxPrice, Integer minDiscount, String sort, Boolean isInStock, Integer pageNumber, Integer pageSize);

    public List<ProductDto> recentlyAddedProduct();
}
