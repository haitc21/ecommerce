package ecommerce.product.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Size {

    private String name;
    private int quantity;
}
