package com.example.demo.enttiy

import javax.persistence.*

@Entity
@Table(name = "hellos")
class Hello(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String
)
