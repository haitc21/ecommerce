package ecommerce.product.dto;

import lombok.Data;

@Data
public class CategoryDto {

    private String id;
    private String name;
    private int level;
    private CategoryDto parentCategory;
}
