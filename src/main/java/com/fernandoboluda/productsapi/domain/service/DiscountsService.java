package com.fernandoboluda.productsapi.domain.service;

import static java.util.Collections.max;

import com.fernandoboluda.productsapi.domain.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class DiscountsService {

  public static final int BOOTS_DISCOUNT = 30;
  public static final String BOOTS_CATEGORY = "boots";
  public static final String SKU_NUMBER = "000003";
  public static final int SKU_DISCOUNT = 15;
  public static final int DEFAULT_DISCOUNT = 0;

  public Product applyDiscounts(Product product) {
    Set<Integer> discounts = new HashSet<>();
    discounts.add(DEFAULT_DISCOUNT);
    addCategoryDiscount(product, discounts);
    addSkuDiscounts(product, discounts);
    Integer discountToApply = max(discounts);
    return product.applyDiscount(discountToApply);
  }

  private void addSkuDiscounts(Product product, Set<Integer> discounts) {
    if (SKU_NUMBER.equals(product.getSku())) {
      discounts.add(SKU_DISCOUNT);
    }
  }

  private void addCategoryDiscount(Product product, Set<Integer> discounts) {
    if (BOOTS_CATEGORY.equals(product.getCategory())) {
      discounts.add(BOOTS_DISCOUNT);
    }
  }
}
