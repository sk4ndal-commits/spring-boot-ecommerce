package com.luv2code.ecommerce.dto

import com.luv2code.ecommerce.entity.Country
import com.luv2code.ecommerce.entity.State

class StatesResponse(val _embedded: EmbeddedStates) {
    class EmbeddedStates(val states: List<State>)
}


class CountriesResponse(val _embedded: EmbeddedCountries) {
    class EmbeddedCountries(val countries: List<Country>)
}

