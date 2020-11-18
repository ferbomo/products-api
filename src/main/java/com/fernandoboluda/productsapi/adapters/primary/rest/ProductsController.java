package com.fernandoboluda.productsapi.adapters.primary.rest;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;
import com.fernandoboluda.productsapi.ports.primary.ProductApplication;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductsController {

  private final ProductApplication productApplication;

  @GetMapping
  public ResponseEntity<List<ProductResponse>> getAllProducts(
      @RequestParam Optional<String> category,
      @RequestParam Optional<String> priceLessThan) {
    return ResponseEntity
        .ok(productApplication.getAllProducts(category.orElse(""), priceLessThan.orElse("")));
  }

}
