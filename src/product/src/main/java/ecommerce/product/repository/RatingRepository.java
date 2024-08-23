package ecommerce.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ecommerce.product.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByProductId(String productId);
}
