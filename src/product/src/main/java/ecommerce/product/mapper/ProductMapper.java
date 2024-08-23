package ecommerce.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import ecommerce.product.dto.ProductDto;
import ecommerce.product.dto.ProductRequestDto;
import ecommerce.product.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequestDto res);

    ProductDto toDto(Product product);

    void updateProduct(@MappingTarget Product product, ProductRequestDto res);
}
