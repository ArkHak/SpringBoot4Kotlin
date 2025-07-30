package o.mysin.spring_boot_kotlin_test.exception

class QuoteNotFoundException(
    private val id: Long
) : RuntimeException(
    "A quote with ID $id not found"
)