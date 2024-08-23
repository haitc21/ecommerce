package ecommerce.product.dto;

import lombok.Data;

@Data
public class CategoryRequestDto {

    private String name;
    private int level;
    private String parentId;
}
