package com.example.proyecto.service

import com.example.proyecto.model.Classrooms
import com.example.proyecto.repository.ClassroomsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Controller
class ClassroomsService {

    @Autowired
    lateinit var classroomsRepository: ClassroomsRepository

    fun list(): List<Classrooms> {
        return classroomsRepository.findAll()

    }

    @PostMapping
    fun save(@RequestBody classrooms: Classrooms): Classrooms {

        return classroomsRepository.save(classrooms)

    }

    @PutMapping
    fun update(classrooms: Classrooms): Classrooms {
        try {
            classroomsRepository.findById(classrooms.id)
                    ?: throw Exception("ID no existe")

            return classroomsRepository.save(classrooms)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping

    fun updateName(classrooms: Classrooms): Classrooms {
        try {
            val response = classroomsRepository.findById(classrooms.id)
                    ?: throw Exception("Id Existe")
            response.apply {
                teacher = classrooms.teacher
            }
            return classroomsRepository.save(classrooms)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

        fun validateAge(age:Long):Boolean{
            return age >18

        }

    }
}
