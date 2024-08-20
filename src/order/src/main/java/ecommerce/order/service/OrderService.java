package ecommerce.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.order.client.InventoryClient;
import ecommerce.order.dto.OrderDto;
import ecommerce.order.dto.OrderRequestDto;
import ecommerce.order.entity.Order;
import ecommerce.order.mapper.OrderMapper;
import ecommerce.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final OrderMapper orderMapper;

    public OrderDto placeOrder(OrderRequestDto dto) {
        Boolean isProductInStock = inventoryClient.isInStock(dto.skuCode(), dto.quantity());
        if (Boolean.FALSE.equals(isProductInStock)) {
            throw new RuntimeException("Product with sku code '" + dto.skuCode() + "' not in stock!");
        }
        Order order = orderMapper.toOrder(dto);
        orderRepository.save(order);
        log.info("Create order successfully!");
        return orderMapper.toDto(order);
    }

    public List<OrderDto> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
