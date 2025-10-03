package com.luv2code.ecommerce.config

import com.luv2code.ecommerce.entity.*
import jakarta.persistence.EntityManager
import jakarta.persistence.metamodel.EntityType
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods
import org.springframework.data.rest.core.mapping.ResourceMetadata
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import java.util.function.Consumer

@Configuration
open class MyDataRestConfig(private val entityManager: EntityManager) : RepositoryRestConfigurer
{
    @Value($$"${allowed.origins}")
    private val theAllowedOrigins: Array<String?> = emptyArray()

    @Value($$"${spring.data.rest.base-path}")
    private val basePath: String? = null

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry)
    {
        val theUnsupportedActions =
            arrayOf<HttpMethod?>(HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST, HttpMethod.PATCH)

        // allow cross-origin
        cors.addMapping("$basePath/**").allowedOrigins(*theAllowedOrigins)

        // disable put,post,delete for Product
        disableHttpMethods(Product::class.java, config, theUnsupportedActions)

        // disable put,post,delete for ProductCategory
        disableHttpMethods(ProductCategory::class.java, config, theUnsupportedActions)

        // disable put, post, delete for Country
        disableHttpMethods(Country::class.java, config, theUnsupportedActions)

        // disable put, post, delete for State
        disableHttpMethods(State::class.java, config, theUnsupportedActions)

        // disable put, post, delete for Order
        disableHttpMethods(Order::class.java, config, theUnsupportedActions)

        exposeIds(config)

        super.configureRepositoryRestConfiguration(config, cors)
    }

    private fun disableHttpMethods(
        theClass: Class<*>?,
        config: RepositoryRestConfiguration,
        theMethods: Array<HttpMethod?>
    )
    {
        config
            .exposureConfiguration
            .forDomainType(theClass)
            .withItemExposure { _: ResourceMetadata?, httpMethods: ConfigurableHttpMethods? ->
                httpMethods!!.disable(
                    *theMethods
                )
            }
            .withCollectionExposure { _: ResourceMetadata?, httpMethods: ConfigurableHttpMethods? ->
                httpMethods!!.disable(
                    *theMethods
                )
            }
    }

    private fun exposeIds(config: RepositoryRestConfiguration)
    {
        val entities = entityManager.metamodel.entities
        val entityClasses: MutableList<Class<*>?> = ArrayList()

        entities.forEach(Consumer { tempEntityType: EntityType<*>? -> entityClasses.add(tempEntityType!!.getJavaType()) })

        val domainTypes = entityClasses.toTypedArray<Class<*>?>()
        config.exposeIdsFor(*domainTypes)
    }
}
