package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
interface CountryRepository : JpaRepository<Country, Long>
