package com.fernandoboluda.productsapi.ports.primary;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductApplication {

  List<ProductResponse> getAllProducts(String category,String priceLessThan);
}
