package com.example.proyecto.repository

import com.example.proyecto.model.Classrooms
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository

interface ClassroomsRepository: JpaRepository<Classrooms, Long> {

    fun findById(id: Long?): Classrooms?

}

