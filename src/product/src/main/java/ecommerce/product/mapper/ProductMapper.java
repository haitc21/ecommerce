package ecommerce.product.mapper;

import org.mapstruct.Mapper;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequestDto dto);

    ProductDto toDto(Product product);
}
