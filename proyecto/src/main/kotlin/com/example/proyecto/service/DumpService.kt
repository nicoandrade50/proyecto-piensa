package com.example.proyecto.service

import com.example.proyecto.model.Dump
import com.example.proyecto.repository.ClassroomsRepository
import com.example.proyecto.repository.DumpRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.server.ResponseStatusException

@Service
class DumpService {

    @Autowired
    lateinit var dumpRepository: DumpRepository

    @Autowired
    lateinit var classroomsRepository: ClassroomsRepository


    fun list(): List<Dump> {
        return dumpRepository.findAll()

    }

    @PutMapping
    fun update(dump: Dump): Dump {
        try {
            dumpRepository.findById(dump.id)
                    ?: throw Exception("ID no existe")

            return dumpRepository.save(dump)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping
    fun updateName(dump: Dump): Dump {
        try {
            val response = dumpRepository.findById(dump.id)
                    ?: throw Exception("Id no Existe")
            response.apply {
                dumpDescription = dump.dumpDescription
            }
            return dumpRepository.save(dump)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PostMapping
    fun save(dump: Dump): Dump {
        try {
            val responseClassrooms = classroomsRepository.findById(dump.classroomsId)
                   ?: throw Exception("Id no Existe")


            val responseDump = dumpRepository.save(dump)

           val totalDump = getTotalDump(dump.classroomsId)



            return responseDump
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun getTotalDump(classroomsId: Long?): Double? {
        return dumpRepository.getTotalDumps(classroomsId)
    }
}