package ecommerce.inventory.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "inventory")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    private String skuCode;
    private Integer quantity;
}
