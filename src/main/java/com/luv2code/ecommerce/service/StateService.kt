package com.luv2code.ecommerce.service

import com.luv2code.ecommerce.dao.StateRepository
import com.luv2code.ecommerce.entity.State
import org.springframework.stereotype.Service

@Service
open class StateService(private val stateRepository: StateRepository) {
    fun findAll(): List<State> = stateRepository.findAll().filterNotNull()
    fun findByCountryCode(code: String): List<State> = stateRepository.findByCountryCode(code).toList()
}
