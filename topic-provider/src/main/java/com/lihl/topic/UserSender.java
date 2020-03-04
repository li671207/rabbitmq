package com.lihl.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class UserSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String message) {
		amqpTemplate.convertAndSend(this.exchange, "user.log.debug", "user.log.debug : " + message);
		amqpTemplate.convertAndSend(this.exchange, "user.log.info", "user.log.info : " + message);
		amqpTemplate.convertAndSend(this.exchange, "user.log.warring", "user.log.warring : " + message);
		amqpTemplate.convertAndSend(this.exchange, "user.log.error", "user.log.error : " + message);
	}

}
