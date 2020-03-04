package com.lihl.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues = "hello-world")
	public void receiver(String message) {
		System.out.println("receiver====>" + message);
	}
}
