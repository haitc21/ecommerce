package ecommerce.product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ecommerce.product.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'category.name': {$regex: ?0, $options: 'i'}}")
    List<Product> findByCategory(String category);

    @Query("{ $or: [ {'title': {$regex: ?0, $options: 'i'}}, {'description': {$regex: ?0, $options: 'i'}}, {'brand': {$regex: ?0, $options: 'i'}}, {'category.name': {$regex: ?0, $options: 'i'}} ] }")
    List<Product> searchProduct(String query);

    @Query("{ 'categoryId': ?0, "
            + "'color': { $in: ?1 }, "
            + "'size.name': { $in: ?2 }, "
            + "'price': { $gte: ?3, $lte: ?4 }, "
            + "'discountPersent': { $gte: ?5 }, "
            + "$or: ["
            + "  { ?6: { $eq: null } }, "
            + "  { ?6: true, 'quantity': { $gt: 0 } }, "
            + "  { ?6: false, 'quantity': { $lt: 1 } }"
            + "] }")
    Page<Product> filter(
            String categoryId,
            List<String> colors,
            List<String> sizeNames,
            Double minPrice,
            Double maxPrice,
            Integer minDiscount,
            Boolean isInStock,
            Pageable pageable);

    List<Product> findTop10ByOrderByCreatedDateDesc();
}
