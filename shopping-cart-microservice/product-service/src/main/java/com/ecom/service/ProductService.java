package com.ecom.productservice;

import com.ecom.ProductServiceApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public ProductServiceApplication.Product saveProduct(ProductServiceApplication.Product product);

    public List<ProductServiceApplication.Product> getAllProducts();

    public Boolean deleteProduct(Integer id);

    public ProductServiceApplication.Product getProductById(Integer id);

    public ProductServiceApplication.Product updateProduct(ProductServiceApplication.Product product, MultipartFile file);

    public List<ProductServiceApplication.Product> getAllActiveProducts(String category);

    public List<ProductServiceApplication.Product> searchProduct(String ch);

    public Page<ProductServiceApplication.Product> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category);

    public Page<ProductServiceApplication.Product> searchProductPagination(Integer pageNo, Integer pageSize, String ch);

    public Page<ProductServiceApplication.Product> getAllProductsPagination(Integer pageNo, Integer pageSize);

    public Page<ProductServiceApplication.Product> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch);

}
