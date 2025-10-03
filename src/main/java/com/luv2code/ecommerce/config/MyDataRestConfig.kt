package com.luv2code.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.luv2code.ecommerce.entity.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

  private final EntityManager entityManager;

  @Value("${allowed.origins}")
  private String[] theAllowedOrigins;

  @Value("${spring.data.rest.base-path}")
  private String basePath;

  public MyDataRestConfig(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST, HttpMethod.PATCH};

    // allow cross-origin
    cors.addMapping(basePath+"/**").allowedOrigins(theAllowedOrigins);

    // disable put,post,delete for Product
    disableHttpMethods(Product.class, config, theUnsupportedActions);

    // disable put,post,delete for ProductCategory
    disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

    // disable put, post, delete for Country
    disableHttpMethods(Country.class, config, theUnsupportedActions);

    // disable put, post, delete for State
    disableHttpMethods(State.class, config, theUnsupportedActions);

    // disable put, post, delete for Order
    disableHttpMethods(Order.class, config, theUnsupportedActions);

    exposeIds(config);

    RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
  }

  private void disableHttpMethods(Class<?> theClass, RepositoryRestConfiguration config, HttpMethod[] theMethods) {
    config
          .getExposureConfiguration()
          .forDomainType(theClass)
          .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theMethods))
          .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theMethods));
  }

  private void exposeIds(RepositoryRestConfiguration config) {
    Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
    List<Class<?>> entityClasses = new ArrayList<>();

    entities.forEach(tempEntityType -> entityClasses.add(tempEntityType.getJavaType()));

    Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
    config.exposeIdsFor(domainTypes);
  }
}
