package com.lihl.fanout;

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
		amqpTemplate.convertAndSend(this.exchange, null, "order.fanout.send : " + message);
	}

}
