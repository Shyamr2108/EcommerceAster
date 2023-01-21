package com.aster.Main;

import com.aster.Main.Entity.Product;
import com.aster.Main.Repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void addProduct(){
//        Product product=new Product();
//        product.setSku(3);
//        product.setName("Soap");
//        product.setDescription("it is washing");
//        product.setImageUrl("jhdkADHKF");
//        product.setQuantity(3);
//        product.setPrice(23.78);
//        productRepository.save(product);
//        Assertions.assertNotNull(productRepository.findById(3).get());
//    }

}
