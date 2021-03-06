package com.lihl.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ProductSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String message) {
		amqpTemplate.convertAndSend(this.exchange, "product.log.debug", "product.log.debug : " + message);
		amqpTemplate.convertAndSend(this.exchange, "product.log.info", "product.log.info : " + message);
		amqpTemplate.convertAndSend(this.exchange, "product.log.warring", "product.log.warring : " + message);
		amqpTemplate.convertAndSend(this.exchange, "product.log.error", "product.log.error : " + message);
	}

}
