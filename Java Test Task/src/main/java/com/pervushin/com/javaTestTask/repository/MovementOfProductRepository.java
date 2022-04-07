package com.pervushin.com.javaTestTask.repository;

import com.pervushin.com.javaTestTask.entity.MovementOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementOfProductRepository extends JpaRepository<MovementOfProduct, Integer> {

    @Query(value = "select * from schema.movement_of_product where id_product = :idProduct", nativeQuery = true)
    MovementOfProduct getTypeOfOperationByIdProduct(Integer idProduct);

    @Query(value = "select sum(quantity_products) from schema.movement_of_product", nativeQuery = true)
    MovementOfProduct getTheTotalQuantityInStock();

}