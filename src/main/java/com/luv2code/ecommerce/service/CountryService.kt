package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.CountryRepository
import com.luv2code.ecommerce.entity.Country
import org.springframework.stereotype.Service

@Service
open class CountryService(private val countryRepository: CountryRepository) {
    fun findAll(): List<Country> = countryRepository.findAll()
}

