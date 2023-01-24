package com.aster.Main.Controller;

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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product){
        List<Product>productList= productService.addProduct(product);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
    //return the one product
    @DeleteMapping("/removeProduct/{id}")
    public ResponseEntity<List<Product>> DeleteProduct(@PathVariable int id){
        List<Product>productList= productService.deleteProduct(id);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id){
        Product product=productService.getProduct(id);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    //Update product





}
