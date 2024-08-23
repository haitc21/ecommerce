package ecommerce.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "category")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String name;
    private int level;
    @DBRef
    private Category parentCategory;

    @Override
    public String getId() {
        return this.id;
    }
}
