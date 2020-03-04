package com.lihl.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;
	@Value("${mq.config.queue.error.routing.key}")
	private String routingKey;

	public void send(String message) {
		System.out.println("send......:" + message);
		amqpTemplate.convertAndSend(this.exchange, this.routingKey, message);
	}

}
