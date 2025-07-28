package o.mysin.spring_boot_kotlin_test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping
    fun helloWorld() = "Hello World Oleg!"
}