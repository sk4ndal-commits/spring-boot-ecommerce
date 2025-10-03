package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
interface IStateRepository : JpaRepository<State?, Long?>
{
    fun findByCountryCode(@Param("code") code: String?): List<State?>?;
}
