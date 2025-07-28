<<<<<<< HEAD
package o.mysin.spring_boot_kotlin_test
=======
package com.o.mysin.spring_boot_basic_kotlin
>>>>>>> master

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
<<<<<<< HEAD
import kotlin.collections.filter
import kotlin.collections.find
import kotlin.collections.indexOfFirst
import kotlin.text.contains
=======
>>>>>>> master

@RestController
@RequestMapping("/quotes")
class QuoteController {

    val quotes = mutableListOf<QuoteDto>()

    // Для получения данных
    @GetMapping
    fun loadQuotes(
        @RequestParam("q", required = false) query: String?
    ): List<QuoteDto> {
        return if (query != null) {
            quotes.filter {
                it.content.contains(query, ignoreCase = true)
            }
        } else quotes
    }

    // Для отправки новых данных
    @PostMapping
    fun postQuote(
        @RequestBody quoteDto: QuoteDto
    ): QuoteDto {
        quotes.add(quoteDto)
        return quoteDto
    }

    // Для замены информации в объекте
    @PutMapping
    fun putQuote(
        @RequestBody quoteDto: QuoteDto
    ): QuoteDto {
        val index = quotes.indexOfFirst { it.id == quoteDto.id }
        quotes[index] = quoteDto

        return quoteDto
    }

    // Для удаления элемента по ID
    @DeleteMapping("/{id}")
    fun deleteQuote(
        @PathVariable("id") id: Long
    ) {
        val quoteToDelete = quotes.find { it.id == id }

        if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

}