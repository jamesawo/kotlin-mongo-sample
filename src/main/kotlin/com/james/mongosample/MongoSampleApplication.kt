package com.james.mongosample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongoSampleApplication

fun main(args: Array<String>) {
    runApplication<MongoSampleApplication>(*args)
}
