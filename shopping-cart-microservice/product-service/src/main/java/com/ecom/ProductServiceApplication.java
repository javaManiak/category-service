package com.ecom.productservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @RequiredArgsConstructor
    @Setter
    @Getter
    @Entity
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(length = 500)
        private String title;

        @Column(length = 5000)
        private String description;

        private String category;

        private Double price;

        private int stock;

        private String image;

        private int discount;

        private Double discountPrice;

        private Boolean isActive;

    }

    @RepositoryRestResource
    public interface ProductRepository extends JpaRepository<Product, Integer> {

        List<Product> findByIsActiveTrue();

        Page<Product> findByIsActiveTrue(Pageable pageable);

        List<Product> findByCategory(String category);

        List<Product> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2);

        Page<Product> findByCategory(Pageable pageable, String category);

        Page<Product> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
                                                                                    Pageable pageable);

        Page<Product> findByisActiveTrueAndTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
                                                                                                   Pageable pageable);
    }

    public interface ProductService {

        public Product saveProduct(Product product);

        public List<Product> getAllProducts();

        public Boolean deleteProduct(Integer id);

        public Product getProductById(Integer id);

        public Product updateProduct(Product product, MultipartFile file);

        public List<Product> getAllActiveProducts(String category);

        public List<Product> searchProduct(String ch);

        public Page<Product> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category);

        public Page<Product> searchProductPagination(Integer pageNo, Integer pageSize, String ch);

        public Page<Product> getAllProductsPagination(Integer pageNo, Integer pageSize);

        public Page<Product> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch);

    }


}

