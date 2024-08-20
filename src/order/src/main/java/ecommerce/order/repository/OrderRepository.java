package ecommerce.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ecommerce.order.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
