package com.luv2code.ecommerce.dao

import com.luv2code.ecommerce.entity.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin

import java.util.List

@RepositoryRestResource
interface StateRepository : JpaRepository<State, Long>
{
    fun findByCountryCode(code: String): List<State>
}
