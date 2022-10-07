package com.order.order.Repo;

import com.order.order.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Integer> {

    Products findByProductid(String valueOf);
}
