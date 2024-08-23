package ecommerce.product.dto;

import java.util.HashSet;
import java.util.Set;

import ecommerce.product.entity.Size;
import lombok.Data;

@Data
public class ProductDto {

    private String id;
    private String title;
    private String description;
    private Double price;
    private Double discountedPrice;
    private int discountPersent;
    private int quantity;
    private String brand;
    private String color;
    private String imageUrl;
    private int numRatings;
    private String categoryId;
    private CategoryDto category;
    private Set<Size> size = new HashSet<>();
}
