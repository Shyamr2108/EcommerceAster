package com.aster.Main.Service;

import com.aster.Main.Entity.Product;
import com.aster.Main.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> addProduct(Product product) {

        productRepository.save(product);
        return productRepository.findAll();
    }

    @Override
    public List<Product> deleteProduct(int sku) {

        productRepository.deleteById(sku);
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int sku) {
        Optional<Product> optProduct=this.productRepository.findById(sku);
        if(optProduct.isPresent()) {
            return optProduct.get();
        }else {
            return null;
        }
//        return productRepository.getById(sku);
    }

    @Override
    public List<Product> listProduct() {

        return productRepository.findAll();
    }
}
