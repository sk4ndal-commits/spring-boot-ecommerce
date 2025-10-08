package com.luv2code.ecommerce.controller

import com.luv2code.ecommerce.dto.StatesResponse
import com.luv2code.ecommerce.entity.State
import com.luv2code.ecommerce.service.StateService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/states")
class StateController(private val stateService: StateService) {
    @GetMapping
    fun getAllStates(): StatesResponse =
        StatesResponse(StatesResponse.EmbeddedStates(stateService.findAll()))

    @GetMapping("/search/findByCountryCode")
    fun findByCountryCode(@RequestParam("code") code: String): StatesResponse =
        StatesResponse(StatesResponse.EmbeddedStates(stateService.findByCountryCode(code)))
}
