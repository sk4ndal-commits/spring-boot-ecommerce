package com.luv2code.ecommerce.controller

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
    fun getAllStates(): List<State> = stateService.findAll()

    @GetMapping("/search/findByCountryCode")
    fun findByCountryCode(@RequestParam("code") code: String): List<State> =
        stateService.findByCountryCode(code)
}

