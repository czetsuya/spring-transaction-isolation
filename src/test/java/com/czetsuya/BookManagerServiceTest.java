package com.czetsuya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.czetsuya.service.BookManagerService;

@SpringBootTest
@DataJpaTest
public class BookManagerServiceTest {

	@Autowired
	private BookManagerService bookManagerService;

	
}
