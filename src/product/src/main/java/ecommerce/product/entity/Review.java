package ecommerce.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "review")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    private String review;
    @Indexed
    private String productId;
    private String userId;

    @Override
    public String getId() {
        return this.id;
    }
}
