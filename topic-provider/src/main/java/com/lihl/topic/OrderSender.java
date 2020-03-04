package com.lihl.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class OrderSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String message) {
		amqpTemplate.convertAndSend(this.exchange, "order.log.debug", "order.log.debug : " + message);
		amqpTemplate.convertAndSend(this.exchange, "order.log.info", "order.log.info : " + message);
		amqpTemplate.convertAndSend(this.exchange, "order.log.warring", "order.log.warring : " + message);
		amqpTemplate.convertAndSend(this.exchange, "order.log.error", "order.log.error : " + message);
	}

}
