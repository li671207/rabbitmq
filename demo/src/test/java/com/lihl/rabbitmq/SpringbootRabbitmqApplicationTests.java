package com.lihl.rabbitmq;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
public class SpringbootRabbitmqApplicationTests {
	@Autowired
	private Sender sender;

	@Test
	public void rabbitMq() {
		sender.send("lihailong");
	}

}
