package com.fernandoboluda.productsapi.config;

import com.fernandoboluda.productsapi.adapters.secondary.json.repository.ProductRepositoryImpl;
import com.fernandoboluda.productsapi.converters.ProductDtoToProductConverter;
import com.fernandoboluda.productsapi.converters.ProductToProductResponseConverter;
import com.fernandoboluda.productsapi.domain.RetrieveAllProductsWithDiscountsUseCase;
import com.fernandoboluda.productsapi.domain.service.DiscountsService;
import com.fernandoboluda.productsapi.ports.primary.ProductApplication;
import com.fernandoboluda.productsapi.ports.secondary.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

  @Bean
  public ProductDtoToProductConverter productDtoToProductConverter() {
    return new ProductDtoToProductConverter();
  }

  @Bean
  public ProductToProductResponseConverter productToProductResponseConverter() {
    return new ProductToProductResponseConverter();
  }

  @Bean
  public ProductRepository productRepository(ProductDtoToProductConverter converter) {
    return new ProductRepositoryImpl(converter);
  }

  @Bean
  public DiscountsService discountsService() {
    return new DiscountsService();
  }

  @Bean
  public ProductApplication productService(ProductRepository repository, DiscountsService service,
      ProductToProductResponseConverter converter) {
    return new RetrieveAllProductsWithDiscountsUseCase(repository, service, converter);
  }

}
