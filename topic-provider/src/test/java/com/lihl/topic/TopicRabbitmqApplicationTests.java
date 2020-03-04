package com.lihl.topic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopicProviderApplication.class)
public class TopicRabbitmqApplicationTests {
	@Autowired
	private UserSender userSender;
	@Autowired
	private ProductSender productSender;
	@Autowired
	private OrderSender orderSender;

	@Test
	public void rabbitMq() {
		userSender.send("lihailong user");
		productSender.send("lihailong product");
		orderSender.send("lihailong order");
	}

}
