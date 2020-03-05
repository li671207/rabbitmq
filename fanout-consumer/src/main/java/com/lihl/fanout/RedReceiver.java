package com.lihl.fanout;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@RabbitListener(bindings = @QueueBinding(
					value = @Queue(value = "${mq.config.queue.red}", autoDelete = "true"),
					exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.FANOUT)))
public class RedReceiver {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("red info receive....." + msg);
	}
}
