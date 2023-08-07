package com.example.proyecto.model

import jakarta.persistence.*

@Entity
@Table (name="classrooms")

class Classrooms {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
    var teacher: String? = null


}