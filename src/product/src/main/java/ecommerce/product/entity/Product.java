package ecommerce.product.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    @NotNull
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
    private Set<Size> size = new HashSet<>();
    @DBRef
    private Category category;

    @Override
    public String getId() {
        return this.id;
    }
}
