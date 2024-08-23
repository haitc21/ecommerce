package ecommerce.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "rating")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    private String userId;
    @Indexed
    private String productId;
    private double rating;

    @Override
    public String getId() {
        return this.id;
    }
}
