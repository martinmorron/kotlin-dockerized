package com.martin.kotlindockerized

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDockerizedApplication

fun main(args: Array<String>) {
	runApplication<KotlinDockerizedApplication>(*args)
}
