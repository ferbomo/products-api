package com.fernandoboluda.productsapi.converters;

import static java.util.stream.Collectors.toList;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.PriceResponse;
import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;
import com.fernandoboluda.productsapi.domain.entities.Price;
import com.fernandoboluda.productsapi.domain.entities.Product;

import java.util.List;

public class ProductToProductResponseConverter {

  public List<ProductResponse> convert(List<Product> products) {
    return products.stream()
        .map(this::convert)
        .collect(toList());
  }

  private ProductResponse convert(Product product) {
    return ProductResponse.builder()
        .sku(product.getSku())
        .name(product.getName())
        .category(product.getCategory())
        .price(createPrice(product.getPrice()))
        .build();
  }

  private PriceResponse createPrice(Price price) {
    return PriceResponse.builder()
        .original(price.getPrice().toString())
        .finalPrice(price.getPriceWithDiscount().toString())
        .currency(price.getCurrency())
        .discountPercentage(formatDiscount(price))
        .build();
  }

  private String formatDiscount(Price price) {
    if (price.getDiscountPercentage().equals(0)) {
      return null;
    }
    return price.getDiscountPercentage().toString() + "%";
  }
}
