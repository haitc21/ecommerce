package ecommerce.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ecommerce.inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
