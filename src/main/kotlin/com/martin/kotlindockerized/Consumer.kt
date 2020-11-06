package com.martin.kotlindockerized

import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@RabbitListener(queues = ["kotlin-morron"])
@Profile("consumer")
class Consumer {

    @RabbitHandler
    open fun receive(message: String) {
        println("Received: [$message]")

    }
}