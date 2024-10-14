package com.ecom.product.category.repository;

import com.ecom.product.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Boolean existsByName(String name);

    public List<Category> findByIsActiveTrue();
}
