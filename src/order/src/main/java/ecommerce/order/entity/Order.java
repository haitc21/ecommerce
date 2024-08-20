package ecommerce.order.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class Order extends AbstractAuditingEntity<String> {

    @Id
    private String id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
