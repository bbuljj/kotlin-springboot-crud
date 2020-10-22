package com.example.demo.repository

import com.example.demo.enttiy.Hello
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloRepository: JpaRepository<Hello, Long>{
}