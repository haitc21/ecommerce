package ecommerce.order.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.order.dto.OrderDto;
import ecommerce.order.dto.OrderRequestDto;
import ecommerce.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto placeOrder(@RequestBody OrderRequestDto dto) {
        return orderService.placeOrder(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

}
