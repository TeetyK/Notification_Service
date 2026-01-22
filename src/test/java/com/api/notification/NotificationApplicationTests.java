package com.api.notification;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(properties = {
    "MAIL_HOST=smtp.gmail.com",
	"MAIL_PORT=587",
	"MAIL_USER=phunyapat.p@gmail.com",
	"MAIL_PW=test",
	"POSTGRE_URL = jdbc:postgresql://localhost:5432/postgres",
	"POSTGRE_USER = postgres",
	"POSTGRE_PW = password"
})
class NotificationApplicationTests {

	@Test
	void contextLoads() {
	}

}
