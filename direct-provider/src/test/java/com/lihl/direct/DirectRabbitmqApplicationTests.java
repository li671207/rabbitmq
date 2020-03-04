package com.lihl.direct;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DirectProviderApplication.class)
public class DirectRabbitmqApplicationTests {
	@Autowired
	private Sender sender;

	@Test
	public void rabbitMq() {
		sender.send("lihailong");
	}

}
