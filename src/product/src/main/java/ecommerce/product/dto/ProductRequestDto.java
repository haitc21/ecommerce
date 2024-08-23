package ecommerce.product.dto;

import java.util.HashSet;
import java.util.Set;

import ecommerce.product.entity.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {

    private String title;
    private String description;
    private double price;
    private double discountedPrice;
    private int discountPersent;
    private int quantity;
    private String brand;
    private String color;
    private String imageUrl;
    private String categoryId;
    private Set<Size> size = new HashSet<>();
    
}
