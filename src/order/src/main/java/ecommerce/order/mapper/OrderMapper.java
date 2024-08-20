package ecommerce.order.mapper;

import org.mapstruct.Mapper;

import ecommerce.order.dto.OrderDto;
import ecommerce.order.dto.OrderRequestDto;
import ecommerce.order.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequestDto dto);

    OrderDto toDto(Order order);
}
