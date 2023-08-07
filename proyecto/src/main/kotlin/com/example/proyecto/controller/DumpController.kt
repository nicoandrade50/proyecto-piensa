package com.example.proyecto.controller

import com.example.proyecto.model.Dump
import com.example.proyecto.service.DumpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dump")
class DumpController {

    @Autowired
    lateinit var dumpService: DumpService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(dumpService.list(), HttpStatus.OK)

    }

    @PostMapping
    fun save(@RequestBody dump: Dump): ResponseEntity<Dump> {
        return ResponseEntity(dumpService.save(dump), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody dump: Dump): ResponseEntity<Dump> {
        return ResponseEntity(dumpService.update(dump), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody dump: Dump): ResponseEntity<Dump> {
        return ResponseEntity(dumpService.updateName(dump), HttpStatus.OK)
    }

}