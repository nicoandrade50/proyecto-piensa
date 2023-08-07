package com.example.proyecto.repository

import com.example.proyecto.model.Dump
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface DumpRepository: JpaRepository<Dump, Long> {

    fun findById (id: Long?): Dump?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun getTotalDumps(@Param("classrooms_id") classroomsId: Long?): Double?

}