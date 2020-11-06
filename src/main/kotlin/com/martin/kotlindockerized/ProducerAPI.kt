package com.martin.kotlindockerized

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom

@RestController
@Profile("producer")
class ProducerAPI(@field:Autowired val rabbitTemplate: RabbitTemplate) {

    @GetMapping("/send")
    fun welcome(): String {

        val messageCount = ThreadLocalRandom.current().nextInt(1000)

        (0 until messageCount).forEach {
            val messageId = ThreadLocalRandom.current().nextLong()
            rabbitTemplate.convertAndSend(
                    RabbitMQConfiguration.getQueueName(), Message("Message#$messageId", emptyList()).toString()
            )
        }

        return "Sent $messageCount messages"
    }

}