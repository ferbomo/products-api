package com.fernandoboluda.productsapi.ports.secondary;

import com.fernandoboluda.productsapi.domain.entities.Product;

import java.util.List;

public interface ProductRepository {

  List<Product> getAllProducts();
}
