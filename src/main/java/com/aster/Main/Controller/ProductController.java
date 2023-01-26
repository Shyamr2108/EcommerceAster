package com.aster.Main.Controller;

import com.aster.Main.DTO.ProductDto;
import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.CartEntry;
import com.aster.Main.Entity.Product;
import com.aster.Main.Entity.User;
import com.aster.Main.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
         productService.addProduct(product);
         Product product1=productService.getProduct(product.getSku());
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }
    //return the one product
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<List<Product>> DeleteProduct(@PathVariable int id){
        List<Product>productList= productService.deleteProduct(id);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id){
        Product product=productService.getProduct(id);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
       Product product= productService.updateProduct(productDto.getId(),
               productDto.getQuantity(),
               productDto.getImageUrl(),
               productDto.getPrice(),
               productDto.getStatus());

        return new ResponseEntity<Product>(product,HttpStatus.OK);

    }





}
