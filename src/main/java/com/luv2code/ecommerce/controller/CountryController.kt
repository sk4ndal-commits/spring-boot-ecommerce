package com.luv2code.ecommerce.controller

import com.luv2code.ecommerce.dto.CountriesResponse
import com.luv2code.ecommerce.entity.Country
import com.luv2code.ecommerce.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/countries")
class CountryController(private val countryService: CountryService) {
    @GetMapping
    fun getAllCountries(): CountriesResponse =
        CountriesResponse(CountriesResponse.EmbeddedCountries(countryService.findAll()))
}
