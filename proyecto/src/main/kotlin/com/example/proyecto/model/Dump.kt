package com.example.proyecto.model

import jakarta.persistence.*

@Entity
@Table(name="dump")
class Dump {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var dumpDescription: String? = null
    var status: Boolean? = null
    var maintenance: String? = null
    @Column(name = "classrooms_id")
    var classroomsId: Long? = null
}