package com.martin.kotlindockerized

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfiguration {

    @Bean
    fun myQueue (): Queue {
        return Queue(getQueueName())
    }

    companion object{
        fun  getQueueName(): String{
            return "kotlin-morron"
        }
    }

}