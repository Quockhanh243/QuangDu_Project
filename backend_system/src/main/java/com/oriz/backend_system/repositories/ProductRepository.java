package com.oriz.backend_system.repositories;

import com.oriz.backend_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT SUM(p.quantity) FROM Product p")
    int calculateTotalProductQuantity();
}
