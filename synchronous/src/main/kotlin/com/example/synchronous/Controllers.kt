package com.example.synchronous

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@RestController
class Controllers {

    @GetMapping(
        path = ["/"]
    )
    @ResponseStatus(HttpStatus.OK)
    fun home(): String {
        return "Hello"
    }

    @GetMapping(
        path = ["/io-bound/{delayMs}"]
    )
    @ResponseStatus(HttpStatus.OK)
    fun ioBound(@PathVariable delayMs: Long) : String {
        // 5 secs io bounded task
        Thread.sleep(delayMs)
        return "ok"
    }

    @GetMapping(
        path = ["/cpu-bound"]
    )
    @ResponseStatus(HttpStatus.OK)
    fun cpuBound() : String {
        val executors = Executors.newFixedThreadPool(5)
        for (thread in 1..5) {
            executors.submit {
                for (i in 1L..30L) {
                    println("Calculating fibonacci for $i")
                    fib(BigInteger.valueOf(i))
                }
            }
        }
        executors.shutdown()
        executors.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)
        return "ok"
    }

    private fun fib(n: BigInteger): BigInteger {
        return if (n.compareTo(BigInteger.ONE) == -1 || n.compareTo(BigInteger.ONE) == 0) n;
        else
            fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.ONE)).subtract(BigInteger.ONE))
    }
}