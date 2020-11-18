package com.fernandoboluda.productsapi.domain;

import static java.util.stream.Collectors.toList;

import com.fernandoboluda.productsapi.adapters.primary.rest.model.ProductResponse;
import com.fernandoboluda.productsapi.converters.ProductToProductResponseConverter;
import com.fernandoboluda.productsapi.domain.entities.Product;
import com.fernandoboluda.productsapi.domain.service.DiscountsService;
import com.fernandoboluda.productsapi.ports.primary.ProductApplication;
import com.fernandoboluda.productsapi.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveAllProductsWithDiscountsUseCase implements ProductApplication {

  private final ProductRepository repository;
  private final DiscountsService discountsService;
  private final ProductToProductResponseConverter converter;

  /**
   * Retrieve products from repository and filter them if there are filtering parameters. After
   * that, applies discounts for each product.
   *
   * @param category      Filter by category. Optional.
   * @param priceLessThan Filter by price less than. Optional.
   * @return A list of ProductResponse objects.
   */
  @Override
  public List<ProductResponse> getAllProducts(String category, String priceLessThan) {

    List<Product> productsWithDiscounts = repository.getAllProducts().stream()
        .filter(product -> category.isEmpty() || category.equals(product.getCategory()))
        .filter(product -> priceLessThan.isEmpty() || product.getPrice().getPrice() <= Integer
            .parseInt(priceLessThan))
        .map(discountsService::applyDiscounts)
        .collect(toList());
    return converter.convert(productsWithDiscounts);
  }

}
