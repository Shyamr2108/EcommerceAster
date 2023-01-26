package com.aster.Main.Service;

import com.aster.Main.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> addProduct(Product product);
    public List<Product> deleteProduct(int sku);
    public Product getProduct(int sku);
    public Product updateProduct(int sku, int quantity, String imageUrl, double price,boolean status);
    public List<Product> listProduct();
}
