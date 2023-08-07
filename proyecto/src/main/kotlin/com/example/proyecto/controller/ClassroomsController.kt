package com.example.proyecto.controller

import com.example.proyecto.model.Classrooms
import com.example.proyecto.service.ClassroomsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/classrooms")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class ClassroomsController {

    @Autowired
    lateinit var classroomsService: ClassroomsService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(classroomsService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody classrooms: Classrooms): ResponseEntity<Classrooms> {
        return ResponseEntity(classroomsService.save(classrooms), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody classrooms: Classrooms): ResponseEntity<Classrooms> {
        return ResponseEntity(classroomsService.update(classrooms), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody classrooms: Classrooms): ResponseEntity<Classrooms> {
        return ResponseEntity(classroomsService.updateName(classrooms), HttpStatus.OK)
    }
}