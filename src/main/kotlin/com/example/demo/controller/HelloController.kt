package com.example.demo.controller

import com.example.demo.dto.HelloDto
import com.example.demo.enttiy.Hello
import com.example.demo.repository.HelloRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
class HelloController(
        val helloRepository: HelloRepository
) {
    @GetMapping
    fun helloList(): ResponseEntity<List<Hello>> {
        val findAll = helloRepository.findAll()
        return ResponseEntity.ok(findAll)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: HelloDto) {
        helloRepository.save(Hello(
                title = request.title
        ))
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun partialUpdate(@RequestBody request: HelloDto, @PathVariable id: Long) {
        val obj = helloRepository.findById(id)
                .orElseThrow { RuntimeException() }
        obj.title = request.title

        helloRepository.save(obj)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        val obj = helloRepository.findById(id)
                .orElseThrow { RuntimeException() }

        helloRepository.delete(obj)
    }
}
