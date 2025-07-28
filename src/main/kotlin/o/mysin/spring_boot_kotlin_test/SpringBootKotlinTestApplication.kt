package o.mysin.spring_boot_kotlin_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinTestApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinTestApplication>(*args)
}
