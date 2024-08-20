package ecommerce.order.dto;

import java.math.BigDecimal;

public record OrderDto(String id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {

}
