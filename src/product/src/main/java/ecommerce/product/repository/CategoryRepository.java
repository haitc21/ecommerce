package ecommerce.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.product.entity.Category;;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String>  {

    public Category findByName(String name);
    
    @Query("{ 'name' : :#{#name}, 'parentCategory.name' : :#{#parentCategoryName} }")
    public Category findByNameAndParant(@Param("name") String name, @Param("parentCategoryName") String parentCategoryName);
}
